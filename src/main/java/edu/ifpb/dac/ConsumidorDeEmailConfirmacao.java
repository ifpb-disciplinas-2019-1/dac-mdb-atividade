package edu.ifpb.dac;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@MessageDriven(
    mappedName = "java:global/jms/email",
        activationConfig = {

                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),

                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:global/jms/email")

        }
)

public class ConsumidorDeEmailConfirmacao implements MessageListener{

    @Override
    public void onMessage(Message message) {

        try {

            String mensagem = message.getBody(String.class);
            
            System.out.println(mensagem);

        } catch (JMSException ex) {

            Logger.getLogger(ConsumidorDeEmailConfirmacao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


}
