package com.example.crudfilmes.service;

import com.example.crudfilmes.domain.Ator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AtorServiceTest {
    @Autowired
    AtorService atorService;

    @Test
    public void adicionaAtorTest(){
        Ator ator1 = Ator.builder()
                .nomeAtor("Ator1")
                .nacionalidade("Brasileiro")
                .build();

        Ator ator2 = Ator.builder()
                .nomeAtor("Ator2")
                .nacionalidade("Mexicano")
                .build();

        Ator retorno1 = atorService.cadastrarAtor(ator1);
        Ator retorno2 = atorService.cadastrarAtor(ator2);

        Assertions.assertEquals(ator1,retorno1);
        Assertions.assertEquals(ator2,retorno2);
    }

}
