package com.example.demo2.service.impl;



import com.example.demo2.exception.ModelNotFoundException;
import com.example.demo2.repository.IRepoGeneric;
import com.example.demo2.service.ICRUDService;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUDService<T, ID> {

    protected abstract IRepoGeneric<T, ID> getRepo();
    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public List<T> list() {
        return getRepo().findAll();
    }

    @Override
    public T update(T t, ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO EXISTE "+ id));
        return getRepo().save(t);
    }

    @Override
    public T readById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO EXISTE "+ id));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO EXISTE "+ id));
        getRepo().deleteById(id);
    }
}
