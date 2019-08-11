package edu.ifpb.dac.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Topic;

import edu.ifpb.dac.model.dao.interfaces.ClienteDAO;
import edu.ifpb.dac.model.dao.interfaces.PedidoDAO;
import edu.ifpb.dac.model.dao.interfaces.ProdutoDAO;
import edu.ifpb.dac.model.entidades.Cliente;
import edu.ifpb.dac.model.entidades.InformacaoPedido;
import edu.ifpb.dac.model.entidades.Pedido;
import edu.ifpb.dac.model.entidades.PedidoItem;
import edu.ifpb.dac.model.entidades.Produto;

//@MessageDriven(activationConfig = {
//        @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Topic"),
//        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "java:global/jms/pedido")
//})
@Stateless
public class PedidoService implements Serializable{
	
	private final char CODIGO_QUANTIDADE = '*';
	
	@Inject
    private PedidoDAO pedidoJPADAO;
	@Inject
    private ProdutoDAO produtoJPADAO;
	@Inject
	private ClienteDAO clienteJPADAO;
	
    private Pedido pedido;
    
    @PostConstruct
    private void init() {
    	criarPedido();
    }
    
    @Resource(lookup = "java:global/jms/pedido")
    private Topic topic;
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory factory;
    
    private void enviarPedidoJMS(InformacaoPedido informacaoPedido) {
    	JMSContext context = factory.createContext();
        JMSProducer producer = context.createProducer();
        // criar a mensagem
        Message mensagem = context.createObjectMessage(informacaoPedido);
        // enviar para o canal de comunicação
        producer.send(
            topic,
            mensagem
        );
    }
    
    private boolean codigoPossuiQuantidade(String codigo) {
    	int posicao = codigo.indexOf(CODIGO_QUANTIDADE);
    	return posicao != -1;
    }
    
    private Produto buscarProdutoPeloCodigo(String codigo) {
    	int inicio = codigoPossuiQuantidade(codigo)?codigo.indexOf(CODIGO_QUANTIDADE) +1:0;
    	int tamanho = codigo.length();
    	String subString = codigo.substring(inicio, tamanho);
    	int idProduto = -1;
    	try {
    		idProduto = Integer.parseInt(subString);
    	}catch (Exception e) {
			return null;
		}
    	return produtoJPADAO.buscarPeloCodigo(idProduto);
    }
    
    private int buscarQuantidadePeloCodigo(String codigo) {
    	if (! codigoPossuiQuantidade(codigo))
    		return 1;
    	int tamanho = codigo.indexOf(CODIGO_QUANTIDADE);    	
    	int quantidade = 1;
    	try {
    		quantidade = Integer.parseInt(codigo.substring(0, tamanho));
    	}catch (Exception e) {}
    	return quantidade;
    }

	public PedidoService() {	}
	
	public Pedido criarPedido() {
		pedido = new Pedido();
		return pedido;
	}
	
	public Pedido cancelarPedido() {
		pedido = new Pedido();
		return pedido;
	}
	
	public Pedido informarCliente(Cliente cliente) {
		if(pedido == null) 
			pedido = criarPedido();
		pedido.setCliente(cliente);
		return pedido;
	}
	
	public Boolean informarClientePeloCpf(String cpf) {
		Cliente cliente = clienteJPADAO.buscarClientePeloCpf(cpf);
		pedido.setCliente(cliente);
		return pedido != null;
	}
	
	public List<PedidoItem> listarItens() {
		return Collections.unmodifiableList(pedido.getItens());
	}
	
	public BigDecimal totalPedido() {
		return pedido.getValorFinal();
	}
		
	public Pedido incluirItem(String codigo) {
		Produto produto = buscarProdutoPeloCodigo(codigo);
		if (produto == null)
			return pedido;
		PedidoItem item = new PedidoItem();
		item.setProduto(produto);
		item.setQuantidade(buscarQuantidadePeloCodigo(codigo));		
		pedido.addItem(item);
		return pedido;				
	}
	
	public Pedido removerItem(Long codigoItem) {
		pedido.removerItem(codigoItem);
		return pedido;
	}
	
	public void efetuarPedido() {
		
		pedidoJPADAO.save(pedido);
		InformacaoPedido informacaoPedido = new InformacaoPedido(
				pedido.getCliente().getCpf(), 
				String.valueOf(pedido.getId()), 
				pedido.getCliente().getEmail(), 
				pedido.getValorFinal(), 
				false);
		enviarPedidoJMS(informacaoPedido);
		pedido = new Pedido();
	}

    }
