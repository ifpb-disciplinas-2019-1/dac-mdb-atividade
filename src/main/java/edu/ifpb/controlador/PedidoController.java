package edu.ifpb.controlador;

import edu.ifpb.dac.Cliente;
import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.Produto;
import edu.ifpb.dac.dao.jpa.PedidoDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ericl
 */
@SuppressWarnings("/serial/")
@RequestScoped
@Named
public class PedidoController implements Serializable {

    @Inject
    PedidoDAO pedidoDAO;

    public String salvar(Pedido pedido){
        this.pedidoDAO.save(pedido);
        return "";
    }
    public String atualizar(Pedido pedido){
        this.pedidoDAO.update(pedido);
        return "";
    }

    public String remover(Pedido pedido){
        this.pedidoDAO.remove(pedido);
        return "";
    }

    public List<Pedido> pedidos(){
        return this.pedidoDAO.list();
    }

}
