package edu.ifpb.dac.dao.jpa;

import edu.ifpb.dac.Pedido;

import java.util.List;

public interface PedidoDAO {

    void save(Pedido pedido);
    void update(Pedido pedido);
    void remove(Pedido pedido);
    List<Pedido> list();

}
