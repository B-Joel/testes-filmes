package com.example.crudfilmes.controller;

import com.example.crudfilmes.domain.Ator;
import com.example.crudfilmes.service.AtorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ator")
@AllArgsConstructor
public class AtorController {

    private AtorService atorService;

    @PostMapping
    public ResponseEntity<Ator> cadastrarAtor(@RequestBody Ator ator) {
        Ator atorCadastrado = atorService.cadastrarAtor(ator);
        return new ResponseEntity<>(atorCadastrado, HttpStatus.CREATED);
    }

}