package edu.ifpb.dac.Util;

import edu.ifpb.dac.model.entidades.Email;

import javax.ejb.Stateless;

/**
 *
 * @author Mailson
 */
@Stateless
public class EncaminhadorDeEmails {

    public void encaminhar(Email email){
        System.out.println("Para: "+email.getDestinatário()+"\nConteúdo: "+email.getCorpo());
    }

}
