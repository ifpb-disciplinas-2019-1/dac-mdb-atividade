package edu.ifpb.dac.dao;

import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.dao.jpa.PedidoDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PedidoJPADAO  implements PedidoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Pedido pedido) {
        try {
            em.persist(pedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pedido pedido) {
        try{
            em.merge(pedido);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Pedido pedido) {
        try {
            Pedido remove = em.find(Pedido.class, pedido.getId());
            em.remove(remove);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Pedido> list() {
        return em.createQuery("SELECT p FROM Pedido p").getResultList();
    }
}
