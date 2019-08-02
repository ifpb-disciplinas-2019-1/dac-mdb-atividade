package cartaoCredito;

import edu.ifpb.dac.Cartao;
import edu.ifpb.dac.InfomacaoPedido;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ValidadorDePedido {

    @PersistenceContext
    private EntityManager em;

    public boolean validar(InfomacaoPedido infomacaoPedido){
        return false;
    }

}
