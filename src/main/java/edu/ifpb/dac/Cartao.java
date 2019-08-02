/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ian
 */
@Entity
public class Cartao implements Serializable{
    @Id
    private String numero;
    private String cpfPropietario;
    private String nomePropietario;
    private String limite;

    public Cartao(String numero, String cpfPropietario, String nomePropietario, String limite) {
        this.numero = numero;
        this.cpfPropietario = cpfPropietario;
        this.nomePropietario = nomePropietario;
        this.limite = limite;
    }

    public Cartao() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpfPropietario() {
        return cpfPropietario;
    }

    public void setCpfPropietario(String cpfPropietario) {
        this.cpfPropietario = cpfPropietario;
    }

    public String getNomePropietario() {
        return nomePropietario;
    }

    public void setNomePropietario(String nomePropietario) {
        this.nomePropietario = nomePropietario;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }
    
}
