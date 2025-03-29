package br.com.locadora.filme;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

	public Object findAll() {
		return repository.findAll((Sort.by("titulo").ascending()));
	}

	public Filme getReferenceById(UUID id) {
		return repository.getReferenceById(id);
	}
}
