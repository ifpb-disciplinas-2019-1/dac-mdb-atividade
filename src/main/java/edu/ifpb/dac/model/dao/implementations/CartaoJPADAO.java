package edu.ifpb.dac.model.dao.implementations;

import edu.ifpb.dac.model.dao.interfaces.CartaoDAO;
import edu.ifpb.dac.model.entidades.Cartao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CartaoJPADAO implements CartaoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Cartao object) {
        em.persist(object);
    }

    @Override
    public void update(Cartao object) {
        em.merge(object);
    }

    @Override
    public void remove(Cartao object) {
        em.remove(em.merge(object));
    }

    @Override
    public List<Cartao> list() {
        String jpql = "SELECT c FROM Cartao c";
        TypedQuery<Cartao> query = em.createQuery(jpql, Cartao.class);
        return query.getResultList();
    }
}
