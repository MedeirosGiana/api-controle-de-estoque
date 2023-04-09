package com.api.controledeestoque.tratamentos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class ManipuladorErros {
    public ResponseEntity<?>methodyArgumentNotValid(MethodArgumentNotValidException e){
        List<Erros> erros = e.getBindingResult().getFieldErrors().stream().map(Erros::new).collect(Collectors.toList());
        erros.addAll(e.getBindingResult().getGlobalErrors().stream().map(err-> new Erros(err.getObjectName().substring(5,12).toLowerCase(), err.getDefaultMessage())).collect(Collectors.toList()));
        return ResponseEntity.badRequest().body(erros);
    }
}
