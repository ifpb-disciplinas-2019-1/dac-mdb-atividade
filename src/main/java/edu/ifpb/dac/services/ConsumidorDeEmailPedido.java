package edu.ifpb.dac.services;

import edu.ifpb.dac.Util.CriadorDeEmails;
import edu.ifpb.dac.Util.EncaminhadorDeEmails;
import edu.ifpb.dac.model.entidades.Email;
import edu.ifpb.dac.model.entidades.InformacaoPedido;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Stateless
public class ConsumidorDeEmailPedido implements MessageListener{

    @Inject
    private EncaminhadorDeEmails encaminhador;


    @Override
    public void onMessage(Message message) {

        try {

            InformacaoPedido informacaoPedido = message.getBody(InformacaoPedido.class);

            Email email = CriadorDeEmails.criarConfirmacao(informacaoPedido);

            encaminhador.encaminhar(email);
        } catch (JMSException ex) {

            Logger.getLogger(ConsumidorDeEmailPedido.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


}
