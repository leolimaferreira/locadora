package br.com.locadora.ator;

import br.com.locadora.filme.Filme;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "filme")
    private List<Filme> filmes;
}
