package com.example.crudfilmes.service;

import com.example.crudfilmes.domain.Ator;
import com.example.crudfilmes.exception.InvalidoGeneroException;
import com.example.crudfilmes.exception.InvalidoNomeException;
import com.example.crudfilmes.repository.AtorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtorService {

    private AtorRepository atorRepository;

    public Ator cadastrarAtor(Ator ator){
        validaAtor(ator);
        return atorRepository.save(ator);
    }

    private void validaAtor(Ator ator){
        if (ator.getNomeAtor() == null || ator.getNomeAtor().equals("")){
            throw new InvalidoNomeException("O ator informado não foi adicionado porque não é possível adicionar um nome nulo");
        }
        if (ator.getNacionalidade() == null || ator.getNacionalidade().equals("")){
            throw new InvalidoGeneroException("O ator informado não foi adicionado porque não é possível adicionar uma nacionalidade nula");
        }
    }
}
