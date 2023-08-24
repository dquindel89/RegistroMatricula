package com.example.demo2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 3, nullable = false)
    private String acronym;

    @Column(nullable = false)
    private boolean state;

    @JsonIgnore
    @ManyToMany(mappedBy = "cursos")
    private Set<Alumno> alumnos = new HashSet<>();
}
