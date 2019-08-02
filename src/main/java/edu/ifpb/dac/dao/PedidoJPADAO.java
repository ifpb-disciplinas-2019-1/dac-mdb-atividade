package edu.ifpb.dac.dao;

import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.dao.jpa.PedidoDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PedidoJPADAO  implements PedidoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Pedido pedido) {
        em.persist(pedido);
    }

    @Override
    public void update(Pedido pedido) {
        em.merge(pedido);
    }

    @Override
    public void remove(Pedido pedido) {
        em.remove(pedido);
    }

    @Override
    public List<Pedido> list() {
        return em.createQuery("SELECT p FROM Pedido p").getResultList();
    }
}
