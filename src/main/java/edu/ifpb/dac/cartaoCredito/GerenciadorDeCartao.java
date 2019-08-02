/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.cartaoCredito;

import edu.ifpb.dac.InfomacaoPedido;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;

/**
 *
 * @author ian
 */
@Stateless
public class GerenciadorDeCartao {
    @Resource(lookup = "java:global/jms/email")
    Queue queue;
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory factory;
    
    public void verificarPedido(InfomacaoPedido informacaoPedido){
        JMSContext context = factory.createContext();
        JMSProducer producer = context.createProducer();
        if(ValidadorDePedido.validar(informacaoPedido)){
            informacaoPedido.setStatus(true);
        }else{
            informacaoPedido.setStatus(false);
        }
        Message message = context.createObjectMessage(informacaoPedido);
        producer.send(queue, message);
    }
}
