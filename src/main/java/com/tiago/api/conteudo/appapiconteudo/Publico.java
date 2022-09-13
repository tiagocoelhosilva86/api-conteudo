package com.tiago.api.conteudo.appapiconteudo;

public enum Publico {
    ASSOCIADOS(0),NAO_ASSOCIADOS(1),ASSOCIADOS_NAO_ASSOCIADOS(3);

    private final int valor;
    Publico(int valorPublico){
        valor = valorPublico;
    }
    public int getValor(){
        return valor;
    }
}
