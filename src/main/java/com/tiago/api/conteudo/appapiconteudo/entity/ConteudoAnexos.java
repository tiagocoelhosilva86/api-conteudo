package com.tiago.api.conteudo.appapiconteudo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conteudo_anexos", schema = "tiago")
public class ConteudoAnexos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_conteudo_anexos")
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conteudo",nullable=false)
    private Conteudo conteudo;

    @Column (name = "flg_tipo_anexo")
    private Integer flgtipoanexo;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "nome")
    private String nome;

    @Column (name = "codigo")
    private String codigo;
}
