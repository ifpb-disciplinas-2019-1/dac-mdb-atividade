/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.cartaoCredito;

import cartaoCredito.ValidadorDePedido;
import edu.ifpb.dac.InformacaoPedido;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;

/**
 *
 * @author ian
 */
@Stateless
public class GerenciadorDeCartao implements MessageListener {

    @Resource(lookup = "java:global/jms/email")
    Queue queue;
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory factory;
    @Inject
    ValidadorDePedido validador;

    @Override
    public void onMessage(Message message) {
        JMSContext context = factory.createContext();
        JMSProducer producer = context.createProducer();
        try {
            InformacaoPedido informacaoPedido = message.getBody(InformacaoPedido.class);
            if (validador.validar(informacaoPedido)) {
                informacaoPedido.setConcluido(true);
            } else {
                informacaoPedido.setConcluido(false);
            }
            producer.send(queue, message);
        } catch (JMSException ex) {
            Logger.getLogger(GerenciadorDeCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
