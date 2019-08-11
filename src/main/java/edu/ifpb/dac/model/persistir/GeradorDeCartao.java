package edu.ifpb.dac.model.persistir;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import edu.ifpb.dac.model.dao.interfaces.CartaoDAO;
import edu.ifpb.dac.model.entidades.Cartao;

@Startup
@Singleton
public class GeradorDeCartao {

    @Inject
    private CartaoDAO cartaoDAO;

    @PostConstruct
    public void init(){
        cartaoDAO.save(new Cartao("123","324235354523","Joao Pedro", BigDecimal.valueOf(2000l)));
        cartaoDAO.save(new Cartao("124","334235354523","Maria", BigDecimal.valueOf(400l)));
        cartaoDAO.save(new Cartao("125","344235354523","Salazar", BigDecimal.valueOf(200l)));
        cartaoDAO.save(new Cartao("126","354235354523","Henrique", BigDecimal.valueOf(3000l)));
        cartaoDAO.save(new Cartao("127","364235354523","Paulino", BigDecimal.valueOf(1500l)));
        cartaoDAO.save(new Cartao("128","374235354523","Jemequerry", BigDecimal.valueOf(500l)));
        cartaoDAO.save(new Cartao("129","384235354523","Felipe", BigDecimal.valueOf(300l)));
        cartaoDAO.save(new Cartao("133","394235354523","Antonio", BigDecimal.valueOf(900l)));
    }
}
