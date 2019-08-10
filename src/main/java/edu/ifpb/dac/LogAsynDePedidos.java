package edu.ifpb.dac;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "java:global/jms/pedido")
})
public class LogAsynDePedidos implements MessageListener {

    private static final Logger LOG = Logger.getLogger(LogAsynDePedidos.class.getName());

    @Override
    public void onMessage(Message message) {
        try{
            String mensagem = message.getBody(String.class);
            LOG.info(mensagem);
        }catch (JMSException jx){
            Logger.getLogger(LogAsynDePedidos.class.getName()).log(Level.SEVERE,null,jx);
        }
    }
}
