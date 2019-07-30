package edu.ifpb.dac;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
public class ProdutorDeEmail {

    @Resource(lookup = "jms/email")
    private Topic topic;

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory factory;

    public void enviarEmail(boolean confirmacao, String destinatário, String corpo){

        JMSContext context = factory.createContext();
        JMSProducer producer = context.createProducer();

        if (confirmacao == false){
            corpo = "OLá "+ destinatário + ", estamos aguardando a confirmação de pagamento.";
        }
        else {
            corpo = "Olá "+ destinatário + ", a compra foi confirmada, espere o envio do produto.";
        }

        //cria email
        ObjectMessage objectMessage = context.createObjectMessage(new Email(destinatário, corpo));

        //envia pra queue
        producer.send(topic, objectMessage);

    }
}
