package edu.ifpb.dac.Util;

import edu.ifpb.dac.model.entidades.Cartao;
import edu.ifpb.dac.model.entidades.InformacaoPedido;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ValidadorDePedido {

    @PersistenceContext
    private EntityManager em;

    public boolean validar(InformacaoPedido infomacaoPedido) {
        String jpql = "SELECT c FROM Cartao c WHERE c.cpfProprietario = :cpf";
        TypedQuery<Cartao> query = em.createQuery(jpql, Cartao.class);
        query.setParameter("cpf",infomacaoPedido.getCpfCliente());
        Cartao cartao = query.getSingleResult();

        return cartao.temLimite(infomacaoPedido.getValorPedido());
    }

}
