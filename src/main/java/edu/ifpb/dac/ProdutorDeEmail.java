package edu.ifpb.dac;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@JMSDestinationDefinitions(

)

@Stateless
public class ProdutorDeEmail {

    @Resource(lookup = "java:global/jms/pedido")
    private Topic compra;

    @Resource(lookup = "java:global/jms/email")
    private Queue confirma;

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory factory;

    public void enviarEmail(boolean confirmacao, String destinatário, String corpo){

        JMSContext context = factory.createContext();
        JMSProducer producer = context.createProducer();
        ObjectMessage objectMessage = null;


        if (confirmacao == false){

            corpo = "OLá "+ destinatário + ", estamos aguardando a confirmação de pagamento.";

            objectMessage = context.createObjectMessage(new Email(destinatário, corpo));

            producer.send(compra, objectMessage);

        }
        else {

            corpo = "Olá "+ destinatário + ", a compra foi confirmada, espere o envio do produto.";

            objectMessage = context.createObjectMessage(new Email(destinatário, corpo));

            producer.send(confirma, objectMessage);

        }



    }
}
