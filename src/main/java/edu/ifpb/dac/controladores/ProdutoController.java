package edu.ifpb.dac.controladores;

import edu.ifpb.dac.model.entidades.Produto;
import edu.ifpb.dac.model.dao.interfaces.ProdutoDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("/serial/")
@RequestScoped
@Named
public class ProdutoController implements Serializable {

    @Inject
    private ProdutoDAO produtoDAO;

    public List<Produto> produtos(){
        return this.produtoDAO.list();
    }

    public String remover(Produto produto){
        this.produtoDAO.remove(produto);
        return "";
    }
}
