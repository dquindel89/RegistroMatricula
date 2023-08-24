package com.example.demo2.service.impl;

import com.example.demo2.model.RegistroMatricula;
import com.example.demo2.repository.IRepoGeneric;
import com.example.demo2.repository.RegistroMatriculaRepo;
import com.example.demo2.service.IRegistroMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistroMatriculaImpl extends CRUDImpl<RegistroMatricula,Integer> implements IRegistroMatriculaService {

    private final RegistroMatriculaRepo repo;

    @Override
    protected IRepoGeneric<RegistroMatricula, Integer> getRepo() {
        return repo;
    }
}
