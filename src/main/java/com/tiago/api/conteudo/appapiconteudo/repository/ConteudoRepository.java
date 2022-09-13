package com.tiago.api.conteudo.appapiconteudo.repository;

import com.tiago.api.conteudo.appapiconteudo.dto.ConteudoDto;
import com.tiago.api.conteudo.appapiconteudo.entity.Conteudo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo,Integer>, JpaSpecificationExecutor<Conteudo> {

    @Query(value="select new com.tiago.api.conteudo.appapiconteudo.dto.ConteudoDto(c) " +
            "from com.tiago.api.conteudo.appapiconteudo.entity.Conteudo c " +
            "where (:publico = -1 or c.publico = :publico ) " +
            "and (:situacao = -1 or c.situacao = :situacao ) " +
            "and (:dtinicio = null or c.dtInicio = :dtinicio) " +
            "and (:dtfinal = null or c.dtTermino = :dtfinal) ",
            countQuery="select count(*) from com.tiago.api.conteudo.appapiconteudo.entity.Conteudo c "+
                    "where (:publico = -1 or c.publico = :publico ) " +
                    "and (:situacao = -1 or c.situacao = :situacao ) " +
                    "and (:dtinicio = null or c.dtInicio = :dtinicio) " +
                    "and (:dtfinal = null or c.dtTermino = :dtfinal) "
    )
    Page<ConteudoDto> obterConteudos(@Param("publico") Integer publico,
                                     @Param("situacao") Integer situacao,
                                     @Param("dtinicio") Date dtinicio,
                                     @Param("dtfinal") Date dtfinal,
                                     Pageable pageable);

    @Query(value="select new com.tiago.api.conteudo.appapiconteudo.dto.ConteudoDto(c) " +
            "from com.tiago.api.conteudo.appapiconteudo.entity.Conteudo c " +
            "where ID = :id "
    )
    ConteudoDto obterConteudoPorId(@Param("id") Integer id);
}
