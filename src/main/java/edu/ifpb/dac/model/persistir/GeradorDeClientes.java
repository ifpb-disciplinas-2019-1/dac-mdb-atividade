package edu.ifpb.dac.model.persistir;

import edu.ifpb.dac.model.dao.interfaces.ClienteDAO;
import edu.ifpb.dac.model.entidades.Cliente;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.math.BigDecimal;

/**
 *
 * @author Mailson
 */
@Startup
@Singleton
public class GeradorDeClientes {

    @Inject
    private ClienteDAO clienteDAO;

    @PostConstruct
    private void init(){
        clienteDAO.save(new Cliente("joao@email.com","324235354523","Joao Pedro"));
        clienteDAO.save(new Cliente("maria@gmail.com","334235354523","Maria"));
        clienteDAO.save(new Cliente("salazar@gmail.com","344235354523","Salazar"));
        clienteDAO.save(new Cliente("henrique@hotmail.com","354235354523","Henrique"));
        clienteDAO.save(new Cliente("paulinhoCritao@gmail.com","364235354523","Paulino"));
        clienteDAO.save(new Cliente("jemequerry@querryjeme.com","374235354523","Jemequerry"));
        clienteDAO.save(new Cliente("felipinhoPressao@gmail.com","384235354523","Felipe"));
        clienteDAO.save(new Cliente("tonynhorodrigues@email.com","394235354523","Antonio"));
    }

}
