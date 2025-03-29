package br.com.locadora.ator;

import br.com.locadora.filme.Filme;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "ator")
public class Ator {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes;
}