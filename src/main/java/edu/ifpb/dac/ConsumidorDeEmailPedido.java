package edu.ifpb.dac;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
    mappedName = "java:global/jms/pedido",
        activationConfig = {

                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),

                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:global/jms/pedido")

        }
)

public class ConsumidorDeEmailPedido implements MessageListener{

    @Override
    public void onMessage(Message message) {

        try {

            String mensagem = message.getBody(String.class);
            
            System.out.println(mensagem);

        } catch (JMSException ex) {

            Logger.getLogger(ConsumidorDeEmailPedido.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


}
