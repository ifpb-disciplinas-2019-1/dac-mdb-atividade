package edu.ifpb.dac.model.dao.interfaces;

import edu.ifpb.dac.model.entidades.Produto;

public interface ProdutoDAO extends GenericDAO<Produto> {
	
	Produto buscarPeloCodigo(int codigo);

}
