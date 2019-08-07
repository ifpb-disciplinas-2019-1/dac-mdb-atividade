package edu.ifpb.dac.dao;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Topic;

import edu.ifpb.dac.*;

public class PedidoService {

    private PedidoJPADAO pedidoJPADAO;
    
    @Resource(lookup = "jms/pedido")
    private Topic topic;
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory factory;
    
    private void enviarPedidoJMS(InfomacaoPedido informacaoPedido) {
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
		InfomacaoPedido infomacaoPedido = new InfomacaoPedido(
				"", 
				pedido.getId(), 
				pedido.getCliente().getEmail(), 
				(Big 0.3, 
				false);
	
		
		
		
	}
    
    

    }
