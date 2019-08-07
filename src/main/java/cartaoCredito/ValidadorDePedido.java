package cartaoCredito;

import edu.ifpb.dac.Cartao;
import edu.ifpb.dac.InformacaoPedido;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.math.BigDecimal;

@Stateless
public class ValidadorDePedido {

    @PersistenceContext
    private EntityManager em;

    public boolean validar(InformacaoPedido infomacaoPedido) {
        String jpql = "SELECT c FROM Cartao c WHERE c.cpfProprietario = :cpf";
        TypedQuery<Cartao> query = em.createQuery(jpql, Cartao.class);
        query.setParameter("cpf",infomacaoPedido.getCpfCliente());
        Cartao cartao = query.getSingleResult();

        return cartao.getLimite().compareTo(infomacaoPedido.getValorPedido()) > 0;
    }

}
