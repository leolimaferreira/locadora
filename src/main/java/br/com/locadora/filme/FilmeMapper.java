package br.com.locadora.filme;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FilmeMapper {

    public abstract Filme toEntity(DadosListagemFilme dto);

    public abstract DadosListagemFilme toDTO(Filme filme);
}
