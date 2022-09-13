package com.tiago.api.conteudo.appapiconteudo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conteudo_videos", schema = "tiago")
public class ConteudoVideos {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_conteudo_videos")
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conteudo",nullable=false)
    private Conteudo conteudo;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "url")
    private String url;
}
