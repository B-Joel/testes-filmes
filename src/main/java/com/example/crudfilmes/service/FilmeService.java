package com.example.crudfilmes.service;

import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.exception.*;
import com.example.crudfilmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public Filme cadastrarFilme(Filme filme) {
        validaFilme(filme);
        return filmeRepository.save(filme);
    }

    public void validaFilme(Filme filme){

        if (filme.getNomeFilme() == null || filme.getNomeFilme().equals("")){
            throw new InvalidoNomeException("O filme não foi adicionado por não ter um nome válido");
        }
        if (filme.getGenero()==null || filme.getGenero().equals("")){
            throw new InvalidoGeneroException("O filme não foi adicionado por não ter um gênero válido");
        }
        if(filme.getAnoLancamento() <= 1984 || filme.getAnoLancamento() > 2022){
            throw new InvalidoAnoException("O filme não foi adicionado por não ter um ano válido");
        }
    }

    public Filme buscarPeloNome(String nomeFilme) {
        List<Filme> listaFilmes = filmeRepository.findAll();
        for (Filme filme : listaFilmes) {
            if (filme.getNomeFilme().equals(nomeFilme)){
                return filme;
            }
        }
        throw new NotFoundException("O filme não foi encontrado na lista");
    }

    public List<Filme> buscarPeloGenero(String generoFilme) {
        List<Filme> listaFilmes = filmeRepository.findAll();
        List<Filme> listaRetorno = new ArrayList<>();

        for (Filme filme : listaFilmes) {
            if (filme.getGenero().equals(generoFilme)){
                listaRetorno.add(filme);
            }
        }
        if (listaRetorno.isEmpty()) {
            throw new NotFoundException("O filme não foi encontrado na lista");
        }
        return listaRetorno;
    }

    public List<Filme> buscarPeloAno(Integer anoLancamento) {
        List<Filme> listaFilmes = filmeRepository.findAll();
        List<Filme> listaRetorno = new ArrayList<>();

        for (Filme filme : listaFilmes) {
            if (Objects.equals(filme.getAnoLancamento(), anoLancamento)){
                listaRetorno.add(filme);
            }
        }
        if (listaRetorno.isEmpty()) {
            throw new NotFoundException("O filme não foi encontrado na lista");
        }
        return listaRetorno;
    }
}
