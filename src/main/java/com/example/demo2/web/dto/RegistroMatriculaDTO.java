package com.example.demo2.web.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegistroMatriculaDTO {

    private Integer id;


    private LocalDateTime fechaMatricula;


    private AlumnoDTO alumno;

    private boolean estado;

    @JsonManagedReference
    private List<DetalleMatriculaDTO> detalleMatriculas;



}
