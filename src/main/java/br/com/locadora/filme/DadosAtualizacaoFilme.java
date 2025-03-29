package br.com.locadora.filme;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizacaoFilme(
	@NotNull
	UUID id,
	String titulo,
	String nomeDiretor) {
}
