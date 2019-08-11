package edu.ifpb.dac.model.dao.interfaces;


import java.util.List;

public interface GenericDAO<T> {
    void save(T object);
    void update(T object);
    void remove(T object);
    List<T> list();
}