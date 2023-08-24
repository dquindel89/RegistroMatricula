package com.example.demo2.web;

import com.example.demo2.model.DetalleMatricula;
import com.example.demo2.service.IDetalleMatriculaService;
import com.example.demo2.web.dto.DetalleMatriculaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles")
@RequiredArgsConstructor
public class DetalleMatriculaController {

    private final ModelMapper mapper;
    private final IDetalleMatriculaService iDetalleMatriculaService;

    @PostMapping
    public ResponseEntity<DetalleMatriculaDTO> save(@RequestBody DetalleMatriculaDTO dto){
        DetalleMatricula detalleMatricula = iDetalleMatriculaService.save(convertEntity(dto));
        return new ResponseEntity<>(convertDto(detalleMatricula), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DetalleMatriculaDTO>> list(){
        List<DetalleMatriculaDTO> list = iDetalleMatriculaService.list().stream().map(this::convertDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    private DetalleMatriculaDTO convertDto(DetalleMatricula obj){
        return mapper.map(obj, DetalleMatriculaDTO.class);
    }
    private DetalleMatricula convertEntity(DetalleMatriculaDTO dto){
        return mapper.map(dto, DetalleMatricula.class);
    }
}
