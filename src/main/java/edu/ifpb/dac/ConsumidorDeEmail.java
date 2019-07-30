package edu.ifpb.dac;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

@MessageDriven(
    mappedName = "java:global/jms/email"
)
public class ConsumidorDeEmail implements MessageListener{
 
    private Topic topic;
   
    private JMSContext jmsContext;

    @Override
    public void onMessage(Message message) {
        try {
            String mensagem = message.getBody(String.class);
            
            System.out.println(mensagem);
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorDeEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
