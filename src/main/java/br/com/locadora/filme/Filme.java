package br.com.locadora.filme;

import java.io.Serializable;
import java.util.List;

import br.com.locadora.ator.Ator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	
	private String nomeDiretor;

	@ManyToMany(mappedBy = "ator")
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
