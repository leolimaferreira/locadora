package br.com.locadora.filme;

import br.com.locadora.ator.Ator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class Filme{

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;

	@Column(name = "titulo", length = 100, nullable = false)
	private String titulo;

	@Column(name = "nome_diretor", length = 100, nullable = false)
	private String nomeDiretor;

	@ManyToMany(mappedBy = "filmes")
	private List<Ator> atores;

	public Filme(DadosCadastroFilme dados) {
		this.titulo = dados.titulo();
		this.nomeDiretor = dados.nomeDiretor();
	}

	public void atualizarInformacoes(DadosAtualizacaoFilme dados) {
		if (dados.titulo() != null) {
			this.titulo = dados.titulo();
		}

		if (dados.nomeDiretor() != null) {
			this.nomeDiretor = dados.nomeDiretor();
		}
	}
	
}
