package com.tiago.api.conteudo.appapiconteudo;

public enum Situacao {
    RASCUNHO(0),PUBLICADO(1),AGENDADO(2),ENCERRADO(3);

    private final int valor;
    Situacao(int valorSituacao){
        valor = valorSituacao;
    }
    public int getValor(){
        return valor;
    }
}
