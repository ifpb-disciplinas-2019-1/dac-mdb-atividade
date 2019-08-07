package edu.ifpb.dac.PersistirCartao;

import edu.ifpb.dac.Cartao;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@Startup
@Singleton
public class Persistir {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
        em.persist(new Cartao("123","324235354523","Joao Pedro", BigDecimal.valueOf(2000l)));
        em.persist(new Cartao("124","334235354523","Maria", BigDecimal.valueOf(400l)));
        em.persist(new Cartao("125","344235354523","Salazar", BigDecimal.valueOf(200l)));
        em.persist(new Cartao("126","354235354523","Henrique", BigDecimal.valueOf(3000l)));
        em.persist(new Cartao("127","364235354523","Paulino", BigDecimal.valueOf(1500l)));
        em.persist(new Cartao("128","374235354523","Jemequerry", BigDecimal.valueOf(500l)));
        em.persist(new Cartao("129","384235354523","Felipe", BigDecimal.valueOf(300l)));
        em.persist(new Cartao("133","394235354523","Antonio", BigDecimal.valueOf(900l)));
    }
}
