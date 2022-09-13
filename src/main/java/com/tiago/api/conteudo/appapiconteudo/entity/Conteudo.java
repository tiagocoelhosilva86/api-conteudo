package com.tiago.api.conteudo.appapiconteudo.entity;

import lombok.*;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conteudo", schema = "tiago")
public class Conteudo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_conteudo")
    private Integer ID;

    @Column(name = "publico")
    private Integer publico;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "dt_inicio")
    private Date dtInicio;

    @Column(name = "dt_termino")
    private Date dtTermino;

    @Column(name = "situacao")
    private Integer situacao;

    @OneToMany(mappedBy = "conteudo",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConteudoAnexos> anexosList;

    @OneToMany(mappedBy = "conteudo",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConteudoDescricao> descricao;

    @OneToMany(mappedBy = "conteudo",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConteudoCompartilhado> compartilhado;

    @OneToMany(mappedBy = "conteudo",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConteudoVideos>conteudoVideos ;
}
