package edu.ifpb.dac.Util;

import edu.ifpb.dac.model.entidades.Email;
import edu.ifpb.dac.model.entidades.InformacaoPedido;


/**
 *
 * @author Mailson
 */
public class CriadorDeEmails {

    public static Email criarConfirmacao(InformacaoPedido informacaoPedido){
        Email email = new Email();
        String mensagem = "O pedido "+informacaoPedido.getIdPedido()+" foi realizado com sucesso.\n" +
                "Em alguns momentos lhe enviaremos uma confirmação informando se o pedido foi ou não aprovado!";
        email.setDestinatário(informacaoPedido.getEmail());
        email.setCorpo(mensagem);
        return email;
    }

    public static Email criarAprovacao(InformacaoPedido informacaoPedido){
        Email email = new Email();
        String mensagem = "";
        if (informacaoPedido.isConcluido()){
            mensagem = "O pedido "+informacaoPedido.getIdPedido()+" foi aprovado =), bem vindo ao capitalismo!";
        }else{
            mensagem = "O pedido "+informacaoPedido.getIdPedido()+" foi recusado por algum motivo, sinto muito =(.";
        }
        email.setDestinatário(informacaoPedido.getEmail());
        email.setCorpo(mensagem);
        return email;
    }

}
