package com.example.crudfilmes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeFilme;
    private String genero;
    @OneToMany
    private List<Ator> listaAtores;
    private Integer anoLancamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(nomeFilme, filme.nomeFilme) && Objects.equals(genero, filme.genero) && Objects.equals(anoLancamento, filme.anoLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeFilme, genero, anoLancamento);
    }
}
