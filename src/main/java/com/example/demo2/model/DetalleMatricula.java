package com.example.demo2.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class DetalleMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 100, nullable = false)
    private String classroom;

   @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;
   // private String curso;

    @ManyToOne
    @JoinColumn(name = "id_det_mat", nullable = false)
    private RegistroMatricula registroMatricula;
}
