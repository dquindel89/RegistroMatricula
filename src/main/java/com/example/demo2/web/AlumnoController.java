package com.example.demo2.web;

import com.example.demo2.model.Alumno;
import com.example.demo2.service.IAlumnoService;
import com.example.demo2.web.dto.AlumnoDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final IAlumnoService alumnoService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<AlumnoDTO> insertAlumno(@RequestBody AlumnoDTO alumnoDTO){
        Alumno alumno = alumnoService.save(convertEntity(alumnoDTO));
        return new ResponseEntity<>(convertDto(alumno), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> listAlumno(){
        List<AlumnoDTO> list = alumnoService.list().stream().map(this::convertDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/orden")
    public ResponseEntity<List<AlumnoDTO>> listDescEdadAlumno(){
        List<AlumnoDTO> list = alumnoService.findByOrderByEdadDesc().stream().map(this::convertDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> readOnlyId(@PathVariable("id") Integer id) throws Exception{
        AlumnoDTO alumnoDTO = convertDto(alumnoService.readById(id));
        return new ResponseEntity<>(alumnoDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> update(@PathVariable("id") Integer id, @RequestBody AlumnoDTO alumnoDTO){
        alumnoDTO.setId(id);
        Alumno alumno = alumnoService.save(convertEntity(alumnoDTO));
        return new ResponseEntity<>(convertDto(alumno), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoDTO> delete(@PathVariable("id") Integer id) throws Exception{
        alumnoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    private AlumnoDTO convertDto(Alumno obj){
        return mapper.map(obj, AlumnoDTO.class);
    }

    private Alumno convertEntity(AlumnoDTO dto){
        return mapper.map(dto,Alumno.class);
    }
}
