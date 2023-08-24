package com.example.demo2.service.impl;

import com.example.demo2.model.Alumno;
import com.example.demo2.repository.IAlumnoRepo;
import com.example.demo2.repository.IRepoGeneric;
import com.example.demo2.service.IAlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService extends CRUDImpl<Alumno,Integer> implements IAlumnoService {

    private final IAlumnoRepo repo;
    @Override
    protected IRepoGeneric<Alumno, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Alumno> findByOrderByEdadDesc() {
        return repo.findByOrderByEdadDesc();
    }
}
