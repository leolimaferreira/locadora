package br.com.locadora.filme;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/filme")
public class FilmeController {

	private final FilmeService service;
	private final FilmeMapper mapper;
	
	@GetMapping ("/formulario")                  
	public String carregaPaginaFormulario (UUID id, Model model){
		System.out.println("Id" + id);
		if(id != null) {
	        var filme = service.getReferenceById(id);
	        model.addAttribute("filme", filme);
	    }
	    return "filme/formulario";              
	}     
	@GetMapping                                           
	public String carregaPaginaListagem (Model model){    
	    model.addAttribute("lista", service.findAll());
	    return "filme/listagem";                         
	} 

	@PostMapping("{id}")
	public String salvar(@RequestBody @Valid DadosCadastroFilme dados) {
		Filme filme = mapper.toEntity(dados);
		service.salvar(filme);
		return  "redirect:filme";
	}
	
	@PutMapping("{id}")
	public String atualizar (
			@PathVariable("id") String id,
			@RequestBody @Valid DadosCadastroFilme dados) {

		service.obterPorId(UUID.fromString(id))
				.map(filme -> {
					Filme entidadeAux = mapper.toEntity(dados);
					filme.setTitulo(entidadeAux.getTitulo());
					filme.setNomeDiretor(entidadeAux.getNomeDiretor());

					service.atualizar(filme);

					return "redirect:filme";
				});

		return "redirect:filme";
	}
	
	@DeleteMapping
	public String removeFilme (@PathVariable("id") String id) {
		service.obterPorId(UUID.fromString(id))
				.map(filme -> {
					service.excluir(filme);
					return "redirect:filme";
				});
		return "redirect:filme";  
	}
	
}
