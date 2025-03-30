package br.com.locadora.filme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroFilme(
		@NotNull(message = "campo obrigatório")
		@Size(max = 100, message = "campo fora do tamanho padrão")
		String titulo,
		@NotNull(message = "campo obrigatório")
		@Size(max = 100, message = "campo fora do tamanho padrão")
		String nomeDiretor) {
}
