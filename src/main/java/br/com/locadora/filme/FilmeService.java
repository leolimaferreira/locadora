package br.com.locadora.filme;

import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmeService {

	private final FilmeRepository repository;
	
	public Filme salvar(Filme filme) {
		return repository.save(filme);
	}

	public void excluir(Filme filme) {
		repository.delete(filme);
	}

	public Optional<Filme> obterPorId(UUID id) {
		return repository.findById(id);
	}

	public void atualizar(Filme filme) {
		if(filme.getId() == null) {
			throw new IllegalArgumentException("Filme não cadastrado");
		}

		repository.save(filme);
	}
}
