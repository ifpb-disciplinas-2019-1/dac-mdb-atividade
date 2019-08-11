/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.services;

import edu.ifpb.dac.Util.ValidadorDePedido;
import edu.ifpb.dac.model.entidades.InformacaoPedido;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 *
 * @author ian
 */

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "java:global/jms/pedido")
})
@Stateless
public class CartaoService implements MessageListener {

    @Resource(lookup = "java:global/jms/email")
    private Queue queue;

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
            message = context.createObjectMessage(informacaoPedido);
            producer.send(queue, message);
        } catch (JMSException ex) {
            Logger.getLogger(CartaoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
