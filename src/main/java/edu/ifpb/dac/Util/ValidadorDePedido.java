package edu.ifpb.dac.Util;

import edu.ifpb.dac.model.entidades.Cartao;
import edu.ifpb.dac.model.entidades.InformacaoPedido;

import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Mailson
 */
@Stateless
public class ValidadorDePedido {

    @PersistenceContext
    private EntityManager em;

    public boolean validar(InformacaoPedido infomacaoPedido) {
        String jpql = "SELECT c FROM Cartao c WHERE c.cpfPropietario = :cpf";
        TypedQuery<Cartao> query = em.createQuery(jpql, Cartao.class);
        query.setParameter("cpf",infomacaoPedido.getCpfCliente());
        Cartao cartao = query.getSingleResult();

        return cartao.temLimite(infomacaoPedido.getValorPedido());
    }

}
