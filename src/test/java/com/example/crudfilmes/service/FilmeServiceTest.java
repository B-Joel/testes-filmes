package com.example.crudfilmes.service;

import com.example.crudfilmes.domain.Ator;
import com.example.crudfilmes.domain.Filme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FilmeServiceTest {
    @Autowired
    AtorService atorService;

    @Autowired
    FilmeService filmesService;

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

        atorService.cadastrarAtor(ator1);
        atorService.cadastrarAtor(ator2);

        Filme filme = Filme.builder()
                .nomeFilme("Hitman: Agente 47")
                .anoLancamento(2015)
                .listaAtores(List.of(ator1,ator2))
                .genero("ação")
                .build();

        Filme filmeRetorno = filmesService.cadastrarFilme(filme);

        Assertions.assertEquals(filme,filmeRetorno);
    }
    @Test
    public void buscaPorGeneroTest(){
        Ator ator1 = Ator.builder()
                .nomeAtor("Ator1")
                .nacionalidade("Argentino")
                .build();

        Ator ator2 = Ator.builder()
                .nomeAtor("Ator2")
                .nacionalidade("Uruguaio")
                .build();

        atorService.cadastrarAtor(ator1);
        atorService.cadastrarAtor(ator2);

        Filme filme1 = Filme.builder()
                .nomeFilme("Hitman: Agente 47")
                .anoLancamento(2015)
                .listaAtores(List.of(ator1,ator2))
                .genero("ação")
                .build();


       filmesService.cadastrarFilme(filme1);

        List<Filme> retorno = filmesService.buscarPeloGenero("ação");

        Assertions.assertEquals(retorno.get(0).getNomeFilme(), filme1.getNomeFilme());
        Assertions.assertEquals(retorno.get(0).getAnoLancamento(), filme1.getAnoLancamento());
    }
    @Test
    public void buscaPorAnoTest(){
        Ator ator1 = Ator.builder()
                .nomeAtor("Ator1")
                .nacionalidade("Argentino")
                .build();

        Ator ator2 = Ator.builder()
                .nomeAtor("Ator2")
                .nacionalidade("Uruguaio")
                .build();

        atorService.cadastrarAtor(ator1);
        atorService.cadastrarAtor(ator2);

        Filme filme = Filme.builder()
                .nomeFilme("Hitman: Agente 47")
                .anoLancamento(2015)
                .listaAtores(List.of(ator1,ator2))
                .genero("ação")
                .build();

        filmesService.cadastrarFilme(filme);

        List<Filme> retorno = filmesService.buscarPeloAno(2015);

        Assertions.assertEquals(retorno.get(0).getNomeFilme(), filme.getNomeFilme());
        Assertions.assertEquals(retorno.get(0).getAnoLancamento(), filme.getAnoLancamento());
    }

}