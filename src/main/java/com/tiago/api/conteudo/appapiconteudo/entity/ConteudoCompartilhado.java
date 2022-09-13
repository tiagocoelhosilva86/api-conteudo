package com.tiago.api.conteudo.appapiconteudo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conteudo_compartilhado", schema = "tiago")
public class ConteudoCompartilhado {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_conteudo_compartilhado")
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conteudo",nullable=false)
    private Conteudo conteudo;

    @Column (name = "cod_central")
    private String codcentral;

    @Column (name = "cod_cooperativa")
    private String codcooperativa;

}
