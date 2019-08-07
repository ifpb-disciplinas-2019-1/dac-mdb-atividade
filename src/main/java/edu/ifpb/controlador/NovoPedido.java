package edu.ifpb.controlador;

import edu.ifpb.dac.Cliente;
import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.Produto;
import edu.ifpb.dac.dao.jpa.PedidoDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 *
 * @author ericl
 */
@SuppressWarnings("/serial/")
@RequestScoped
@Named
public class NovoPedido {

    @Inject
    PedidoDAO pedidoDAO;

    public 
}
