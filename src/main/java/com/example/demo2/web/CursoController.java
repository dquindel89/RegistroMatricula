package com.example.demo2.web;

import com.example.demo2.model.Curso;
import com.example.demo2.service.ICursoService;
import com.example.demo2.web.dto.CursoDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService iCursoService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<CursoDTO> insertCurso(@RequestBody CursoDTO cursoDTO) throws Exception{
        Curso curso = iCursoService.save(convertEntity(cursoDTO));
        return new ResponseEntity<>(convertDto(curso), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listCurso(){
        List<CursoDTO> list = iCursoService.list().stream().map(this::convertDto).toList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> readOnlyId(@PathVariable("id") Integer id) throws Exception{
        CursoDTO cursoDTO = convertDto(iCursoService.readById(id));
        return new ResponseEntity<>(cursoDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@PathVariable("id") Integer id, @RequestBody CursoDTO cursoDTO){
        cursoDTO.setId(id);
        Curso curso = iCursoService.save(convertEntity(cursoDTO));
        return new ResponseEntity<>(convertDto(curso), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CursoDTO> delete(@PathVariable("id") Integer id) throws Exception{
        iCursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CursoDTO convertDto(Curso obj){
        return mapper.map(obj, CursoDTO.class);
    }

    private Curso convertEntity(CursoDTO dto){
        return mapper.map(dto, Curso.class);
    }


}
