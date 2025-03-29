package br.com.locadora.filme;

import java.util.UUID;

public record DadosListagemFilme(
	UUID id,
	String titulo,
	String nomeDiretor) {
}
