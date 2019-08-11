package edu.ifpb.dac.model.dao.interfaces;

import edu.ifpb.dac.model.entidades.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente> {
	
	Cliente buscarClientePeloCpf(String cpf);

}
