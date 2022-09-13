package com.tiago.api.conteudo.appapiconteudo.dto;

import com.tiago.api.conteudo.appapiconteudo.entity.ConteudoCompartilhado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoCompartilhadoDto {

    private String codcentral;
    private String codcooperativa;

    public ConteudoCompartilhadoDto(ConteudoCompartilhado conteudoCompartilhado){

        codcentral = conteudoCompartilhado.getCodcentral();
        codcooperativa = conteudoCompartilhado.getCodcooperativa();
    }

}
