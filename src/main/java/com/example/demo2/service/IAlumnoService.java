package com.example.demo2.service;

import com.example.demo2.model.Alumno;

import java.util.List;

public interface IAlumnoService extends ICRUDService<Alumno,Integer> {

    List<Alumno> findByOrderByEdadDesc();
}
