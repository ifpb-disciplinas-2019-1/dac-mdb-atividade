package edu.ifpb.dac.dao;

import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.dao.jpa.PedidoDAO;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PedidoJPADAO  implements PedidoDAO {
    @Override
    public void save(Pedido pedido) {

    }

    @Override
    public void update(Pedido pedido) {

    }

    @Override
    public void remove(Pedido pedido) {

    }

    @Override
    public List<Pedido> list() {
        return null;
    }
}
