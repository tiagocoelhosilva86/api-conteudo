package com.tiago.api.conteudo.appapiconteudo.dto;

import com.tiago.api.conteudo.appapiconteudo.Publico;
import com.tiago.api.conteudo.appapiconteudo.Situacao;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ConteudoCreateDto {
    private Publico publico;
    private String titulo;
    private Situacao situacao;
    private Date dtInicio;
    private Date dtFim;
}
