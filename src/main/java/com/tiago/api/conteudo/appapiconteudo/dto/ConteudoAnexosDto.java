package com.tiago.api.conteudo.appapiconteudo.dto;

import com.tiago.api.conteudo.appapiconteudo.entity.ConteudoAnexos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoAnexosDto {

    private Integer flgtipoanexo;
    private String descricao;
    private String nome;
    private String codigo;

    public ConteudoAnexosDto(ConteudoAnexos anexos){
        flgtipoanexo = anexos.getFlgtipoanexo();
        descricao = anexos.getDescricao();
        nome = anexos.getNome();
        codigo = anexos.getCodigo();
    }
}
