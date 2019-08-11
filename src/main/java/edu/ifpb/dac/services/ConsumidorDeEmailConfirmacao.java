package edu.ifpb.dac.services;

import edu.ifpb.dac.Util.CriadorDeEmails;
import edu.ifpb.dac.Util.EncaminhadorDeEmails;
import edu.ifpb.dac.model.entidades.Email;
import edu.ifpb.dac.model.entidades.InformacaoPedido;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

@Stateless
public class ConsumidorDeEmailConfirmacao implements MessageListener{

    @Inject
    private EncaminhadorDeEmails encaminhador;

    @Override
    public void onMessage(Message message) {

        try {

            InformacaoPedido informacaoPedido = message.getBody(InformacaoPedido.class);

            Email email = CriadorDeEmails.criarAprovacao(informacaoPedido);

            encaminhador.encaminhar(email);

        } catch (JMSException ex) {

            Logger.getLogger(ConsumidorDeEmailConfirmacao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


}
