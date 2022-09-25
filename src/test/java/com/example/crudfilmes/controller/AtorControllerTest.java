package com.example.crudfilmes.controller;

import com.example.crudfilmes.domain.Ator;
import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.service.AtorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtorControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private AtorController atorController;

    @Test
    public void insereAtorControllerTest(){
        Ator ator1 = Ator.builder()
                .nomeAtor("Ator1")
                .nacionalidade("Brasileiro")
                .build();

        Ator ator2 = Ator.builder()
                .nomeAtor("Ator2")
                .nacionalidade("Mexicano")
                .build();

        ResponseEntity<Ator> atorResposta1 = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/ator",
                        ator1, Ator.class);

        ResponseEntity<Ator> atorResposta2 = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/ator",
                        ator2, Ator.class);

        Assertions.assertEquals(HttpStatus.CREATED, atorResposta1.getStatusCode());
        Assertions.assertEquals(HttpStatus.CREATED, atorResposta2.getStatusCode());
    }
}