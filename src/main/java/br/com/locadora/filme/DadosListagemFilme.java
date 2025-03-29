package br.com.locadora.filme;

import java.util.UUID;

public record DadosListagemFilme(
	UUID id,
	String titulo,
	String nomeDiretor) {
	public DadosListagemFilme (Filme filme) {
	    this(filme.getId(),
	    filme.getTitulo(),
	    filme.getNomeDiretor()); 
	}
}
