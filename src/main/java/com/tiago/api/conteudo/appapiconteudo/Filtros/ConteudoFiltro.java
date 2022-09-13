package com.tiago.api.conteudo.appapiconteudo.Filtros;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ConteudoFiltro {
    String central;
    Integer publico;
    Integer situacao;
    Date dtInicio;
    Date dtTermino;

}
