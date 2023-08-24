package com.example.demo2.web.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetalleMatriculaDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    private String classroom;

    @NotNull
    @NotEmpty
    private CursoDTO curso;


    @JsonBackReference
    private RegistroMatriculaDTO registro;
}
