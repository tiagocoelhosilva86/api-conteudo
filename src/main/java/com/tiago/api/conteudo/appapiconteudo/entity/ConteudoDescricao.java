package com.tiago.api.conteudo.appapiconteudo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conteudo_descricao", schema = "tiago")
public class ConteudoDescricao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "id_conteudo_descricao")
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conteudo",nullable=false)
    private Conteudo conteudo;

    @Column (name = "descricao")
    private String descricao;
}
