package edu.ifpb.dac.services;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Topic;

import edu.ifpb.dac.model.dao.implementations.PedidoJPADAO;
import edu.ifpb.dac.model.entidades.InformacaoPedido;
import edu.ifpb.dac.model.entidades.Pedido;

public class PedidoService {

    private PedidoJPADAO pedidoJPADAO;
    
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

	public PedidoService() {
		pedidoJPADAO = new PedidoJPADAO();
	}
	
	public void efetuarPedido(Pedido pedido) {
		pedidoJPADAO.save(pedido);
		
		InformacaoPedido informacaoPedido = new InformacaoPedido(
				"cpf", 
				String.valueOf(pedido.getId()), 
				pedido.getCliente().getEmail(), 
				BigDecimal.valueOf(1.0), 
				false);
	
		
		
		
	}
    
    

    }
