package com.example.demo2.service;

import java.util.List;

public interface ICRUDService<T, ID> {

    T save (T t);
    List<T> list();

    T update(T t, ID id);

    T readById(ID id);
    void delete (ID id);

}
