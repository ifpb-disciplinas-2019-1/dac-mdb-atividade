package edu.ifpb.dac.model.dao.implementations;

import edu.ifpb.dac.model.entidades.Produto;
import edu.ifpb.dac.model.dao.interfaces.ProdutoDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoJPADAO implements ProdutoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Produto produto) {
        em.persist(produto);
    }

    @Override
    public void update(Produto produto) {
        em.merge(produto);
    }

    @Override
    public void remove(Produto produto) {
        em.remove(produto);
    }

    @Override
    public List<Produto> list() {
        return em.createQuery("SELECT p FROM Produto p").getResultList();
    }
}
