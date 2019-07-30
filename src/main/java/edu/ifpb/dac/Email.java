package edu.ifpb.dac;

import java.io.Serializable;

public class Email implements Serializable {

    private String corpo;
    private String destinatário;

    public Email(String corpo, String destinatário) {
        this.corpo = corpo;
        this.destinatário = destinatário;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getDestinatário() {
        return destinatário;
    }

    public void setDestinatário(String destinatário) {
        this.destinatário = destinatário;
    }
}
