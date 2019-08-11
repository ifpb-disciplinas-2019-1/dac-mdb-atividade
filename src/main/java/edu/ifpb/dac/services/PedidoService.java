package edu.ifpb.dac.services;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Topic;

import edu.ifpb.dac.model.dao.implementations.PedidoJPADAO;
import edu.ifpb.dac.model.dao.implementations.ProdutoJPADAO;
import edu.ifpb.dac.model.entidades.Cliente;
import edu.ifpb.dac.model.entidades.InformacaoPedido;
import edu.ifpb.dac.model.entidades.Pedido;
import edu.ifpb.dac.model.entidades.PedidoItem;
import edu.ifpb.dac.model.entidades.Produto;

public class PedidoService {
	
	private final char CODIGO_QUANTIDADE = '*';

    private PedidoJPADAO pedidoJPADAO;
    private ProdutoJPADAO produtoJPADAO;
    
    private Pedido pedido;
    
    @Resource(lookup = "jms/pedido")
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
            topic,mensagem
        );
    }
    
    private boolean codigoPossuiQuantidade(String codigo) {
    	int posicao = codigo.indexOf(CODIGO_QUANTIDADE);
    	return posicao != -1;
    }
    
    private Produto buscarProdutoPeloCodigo(String codigo) {
    	int inicio = codigoPossuiQuantidade(codigo)?codigo.indexOf(CODIGO_QUANTIDADE):0;
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

	public PedidoService() {
		pedidoJPADAO = new PedidoJPADAO();
		produtoJPADAO = new ProdutoJPADAO();
		pedido = new Pedido();
	}
	
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
	
	public Pedido removerItem(int codigoItem) {
		pedido.removerItem(codigoItem);
		return pedido;
	}
	
	public void efetuarPedido(Pedido pedido) {
		pedidoJPADAO.save(pedido);
		
		InformacaoPedido informacaoPedido = new InformacaoPedido(
				"cpf", 
				String.valueOf(pedido.getId()), 
				pedido.getCliente().getEmail(), 
				BigDecimal.valueOf(1.0), 
				false);
		pedido = new Pedido();
	}

    }
