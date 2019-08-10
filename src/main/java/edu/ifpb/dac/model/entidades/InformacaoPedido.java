/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ian
 */
public class InformacaoPedido implements Serializable{
    private String cpfCliente;
    private String idPedido;
    private String email;
    private BigDecimal valorPedido;
    private boolean concluido;

    public InformacaoPedido(String cpfCliente, String idPedido, String email, BigDecimal valorPedido, boolean concluido) {
        this.cpfCliente = cpfCliente;
        this.idPedido = idPedido;
        this.email = email;
        this.valorPedido = valorPedido;
        this.concluido = concluido;
    }
    
    
    

    public InformacaoPedido() {
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    @Override
    public String toString() {
        return "InformacaoPedido{" + "cpfCliente=" + cpfCliente + ", idPedido=" + idPedido + ", valorPedido=" + valorPedido + ", concluido=" + concluido + '}';
    }
    
    
}
