package edu.ifpb.dac.dao.jpa;

import edu.ifpb.dac.Produto;

import java.util.List;

public interface ProdutoDAO {

    void save (Produto produto);
    void update (Produto produto);
    void remove (Produto produto);
    List<Produto> list();

}
