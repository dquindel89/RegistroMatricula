package com.example.demo2.web;


import com.example.demo2.model.Alumno;
import com.example.demo2.model.Curso;
import com.example.demo2.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/relacion-cursos-alumnos")
@RequiredArgsConstructor
public class RelacionController {

    private final ICursoService iCursoService;


    @GetMapping("/mostrar")
    public Map<String, List<String>> mostrarRelacion() {
        List<Curso> cursos = iCursoService.list();

        Map<String, List<String>> relacionCursosAlumnos = cursos.stream()
                .collect(Collectors.toMap(
                        Curso::getNombre,
                        curso -> curso.getAlumnos().stream()
                                .map(Alumno::getName)
                                .collect(Collectors.toList())
                ));

        return relacionCursosAlumnos;
    }


}
