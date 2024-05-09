package org.example.demo13.service;

import java.util.List;

public interface IGenericService <T>{
    List<T> findAll();
    T findByID(int id);
    void create(T o);
    void updateByID(int id);
    void deleteByID(int id);
}
