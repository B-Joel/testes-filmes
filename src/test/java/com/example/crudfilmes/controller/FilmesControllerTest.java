package com.example.crudfilmes.controller;

import com.example.crudfilmes.domain.Ator;
import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.exception.InvalidoAnoException;
import com.example.crudfilmes.service.AtorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmesControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Deve adicionar o filme de maneira correta")
    public void cadastraFilmeTest(){

        Filme filme = Filme.builder()
                .nomeFilme("Hitman: Agente 47")
                .anoLancamento(2015)
                .genero("ação")
                .build();

        ResponseEntity<Filme> respostaFilme = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/filme",
                        filme, Filme.class);

        Assertions.assertEquals(CREATED, respostaFilme.getStatusCode());
        Assertions.assertEquals(filme.getNomeFilme(), respostaFilme.getBody().getNomeFilme());
        Assertions.assertEquals(filme.getGenero(), respostaFilme.getBody().getGenero());
        Assertions.assertEquals(filme.getAnoLancamento(), respostaFilme.getBody().getAnoLancamento());
    }
    @Test
    public void exceptionAnoTest(){
        Filme filme = Filme.builder()
                .nomeFilme("Hitman: Agente 47")
                .anoLancamento(2020)
                .genero("ação")
                .build();

        ResponseEntity<Filme> respostaFilme = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/filme",
                        filme, Filme.class);

        Assertions.assertEquals(respostaFilme.getStatusCode(), HttpStatus.NOT_IMPLEMENTED);
    }


}
