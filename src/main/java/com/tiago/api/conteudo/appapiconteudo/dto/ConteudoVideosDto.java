package com.tiago.api.conteudo.appapiconteudo.dto;

import com.tiago.api.conteudo.appapiconteudo.entity.ConteudoVideos;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoVideosDto {

    private String descricao;
    private String url;

    public ConteudoVideosDto(ConteudoVideos conteudoVideos){

        descricao = conteudoVideos.getDescricao();
        url = conteudoVideos.getUrl();
    }
}
