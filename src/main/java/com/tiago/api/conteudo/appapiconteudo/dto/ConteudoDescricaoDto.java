package com.tiago.api.conteudo.appapiconteudo.dto;

import com.tiago.api.conteudo.appapiconteudo.entity.ConteudoDescricao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoDescricaoDto {

    private String descricao;

    public ConteudoDescricaoDto(ConteudoDescricao conteudoDescricao){

        descricao = conteudoDescricao.getDescricao();
    }

}
