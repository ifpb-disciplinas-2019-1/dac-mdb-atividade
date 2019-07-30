package edu.ifpb.dac;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
public class ProdutorDeEmail {

    @Resource(lookup = "jms/email");
    private Queue queue;

    @Resource(lookup = "jms/__defaultConnectionFactory");
    private ConnectionFactory factory;

    public void enviarEmail(String destinatário, String corpo){

        JMSContext context = factory.createContext();
        JMSProducer producer = context.createProducer();

        //cria email
        ObjectMessage objectMessage = context.createObjectMessage(new Email(destinatário, corpo));

        //envia pra queue
        producer.send(queue, objectMessage);

    }
}
