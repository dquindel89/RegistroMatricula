package com.example.demo2.web;

import com.example.demo2.model.RegistroMatricula;
import com.example.demo2.service.IRegistroMatriculaService;
import com.example.demo2.web.dto.RegistroMatriculaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
@RequiredArgsConstructor
public class RegistroMatriculaController{

    private final ModelMapper mapper;
    private final IRegistroMatriculaService iRegistroMatriculaService;

    @PostMapping
    public ResponseEntity<RegistroMatriculaDTO> save(@Validated @RequestBody RegistroMatriculaDTO registroMatriculaDTO){

        RegistroMatricula registro = iRegistroMatriculaService.save(convertEntity(registroMatriculaDTO));
        return new ResponseEntity<>(convertDto(registro), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RegistroMatriculaDTO>> list(){
        List<RegistroMatriculaDTO> list = iRegistroMatriculaService.list().stream().map(this::convertDto).toList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    private RegistroMatriculaDTO convertDto(RegistroMatricula obj){
        return mapper.map(obj, RegistroMatriculaDTO.class);
    }

    private RegistroMatricula convertEntity(RegistroMatriculaDTO dto){
        return mapper.map(dto, RegistroMatricula.class);
    }
}
