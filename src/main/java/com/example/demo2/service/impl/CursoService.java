package com.example.demo2.service.impl;


import com.example.demo2.model.Curso;
import com.example.demo2.repository.ICursoRepo;
import com.example.demo2.repository.IRepoGeneric;
import com.example.demo2.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService extends CRUDImpl<Curso,Integer> implements ICursoService {

    private final ICursoRepo repo;
    @Override
    protected IRepoGeneric<Curso, Integer> getRepo() {
        return repo;
    }
}
