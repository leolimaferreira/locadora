package br.com.locadora.filme;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	
	private String nomeDiretor;

	public Filme(DadosCadastroFilme dados) {
		this.titulo = dados.titulo();
		this.nomeDiretor = dados.nomeDiretor();
	}

	public Filme( ) {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String nome) {
		this.titulo = nome;
	}
	public String getNomeDiretor() {
		return nomeDiretor;
	}
	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
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
