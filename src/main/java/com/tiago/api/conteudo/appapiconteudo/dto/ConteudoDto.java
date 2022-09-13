package com.tiago.api.conteudo.appapiconteudo.dto;

import com.tiago.api.conteudo.appapiconteudo.Publico;
import com.tiago.api.conteudo.appapiconteudo.Situacao;
import com.tiago.api.conteudo.appapiconteudo.entity.Conteudo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoDto {

    private Publico publico;
    private String titulo;
    private Situacao situacao;

    private List<ConteudoAnexosDto> anexosDtoList = new ArrayList<ConteudoAnexosDto>();
    private List<ConteudoDescricaoDto> descricaoDtoList = new ArrayList<ConteudoDescricaoDto>();
    private List<ConteudoCompartilhadoDto> conteudoCompartilhadoDtoList = new ArrayList<ConteudoCompartilhadoDto>();
    private List<ConteudoVideosDto> conteudoVideosDtoList = new ArrayList<ConteudoVideosDto>();

    public ConteudoDto(Conteudo c){
        setSituacao(Situacao.values()[c.getSituacao()]);
        setPublico(Publico.values()[c.getPublico()]);
        setTitulo(c.getTitulo());
        if(c.getAnexosList() != null){
            setAnexosDtoList(c.getAnexosList().stream().map(ConteudoAnexosDto::new).collect(Collectors.toList()));
        }
        if(c.getDescricao() != null){
            setDescricaoDtoList(c.getDescricao().stream().map(ConteudoDescricaoDto::new).collect(Collectors.toList()));
        }
        if(c.getCompartilhado() != null){
            setConteudoCompartilhadoDtoList(c.getCompartilhado().stream().map(ConteudoCompartilhadoDto::new).collect(Collectors.toList()));
        }
        if(c.getConteudoVideos() != null){
            setConteudoVideosDtoList(c.getConteudoVideos().stream().map(ConteudoVideosDto::new).collect(Collectors.toList()));
        }

    }


}
