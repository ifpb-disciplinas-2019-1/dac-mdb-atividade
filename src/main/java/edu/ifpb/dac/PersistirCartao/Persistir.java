package edu.ifpb.dac.PersistirCartao;

import edu.ifpb.dac.Cartao;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class Persistir {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
//        em.persist(new Cartao("123","344235354523","Joao Pedro",2000));
    }
}
