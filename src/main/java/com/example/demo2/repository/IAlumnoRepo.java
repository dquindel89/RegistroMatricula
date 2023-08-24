package com.example.demo2.repository;

import com.example.demo2.model.Alumno;

import java.util.List;

public interface IAlumnoRepo extends IRepoGeneric<Alumno,Integer> {

    public List<Alumno> findByOrderByEdadDesc();

}
