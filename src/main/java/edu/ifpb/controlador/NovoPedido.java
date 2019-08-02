package edu.ifpb.controlador;

import edu.ifpb.dac.Cliente;
import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.Produto;
import java.util.List;

/**
 *
 * @author ericl
 */
public class NovoPedido {
    
    public Pedido criarPedido(Cliente cliente, List<Produto> produtos){
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProdutos(produtos);
        return pedido;
    }
}
