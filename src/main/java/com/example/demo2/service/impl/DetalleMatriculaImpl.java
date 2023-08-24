package com.example.demo2.service.impl;

import com.example.demo2.model.DetalleMatricula;
import com.example.demo2.repository.DetalleMatriculaRepo;
import com.example.demo2.repository.IRepoGeneric;
import com.example.demo2.service.IDetalleMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleMatriculaImpl extends CRUDImpl<DetalleMatricula,Integer> implements IDetalleMatriculaService {

private final DetalleMatriculaRepo repo;
    @Override
    protected IRepoGeneric<DetalleMatricula, Integer> getRepo() {
        return repo;
    }
}
