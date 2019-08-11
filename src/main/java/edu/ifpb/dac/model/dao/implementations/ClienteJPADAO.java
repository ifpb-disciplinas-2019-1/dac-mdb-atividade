package edu.ifpb.dac.model.dao.implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.ifpb.dac.model.dao.interfaces.ClienteDAO;
import edu.ifpb.dac.model.entidades.Cliente;

@Stateless
public class ClienteJPADAO implements ClienteDAO {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public void save(Cliente object) {
		em.persist(object);
		
	}

	@Override
	public void update(Cliente object) {
		em.merge(object);
	}

	@Override
	public void remove(Cliente object) {
		em.remove(object);
	}

	@Override
	public List<Cliente> list() {
		return em.createQuery("SELECT c FROM Cliente c ",Cliente.class).getResultList();
	}

	@Override
	public Cliente buscarClientePeloCpf(String cpf) {
		String jpql = "SELECT c FROM Cliente c "
				+ "WHERE c.cpf = :cpf";
		TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
		query.setParameter("cpf", cpf);
		return query.getSingleResult();
	}
	

}
