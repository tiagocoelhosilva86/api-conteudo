package com.tiago.api.conteudo.appapiconteudo.Filtros;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import com.tiago.api.conteudo.appapiconteudo.entity.Conteudo;
import org.springframework.data.jpa.domain.Specification;

public class ConteudoSpecifications {
    public static Specification<Conteudo> getFilteredConteudos(ConteudoFiltro params) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (params.getPublico() != null) {
                predicates.add(criteriaBuilder.equal(root.get("publico"), params.getPublico()));
            }

            if (params.getSituacao() != null) {
                predicates.add(criteriaBuilder.equal(root.get("situacao"), params.getSituacao()));
            }

            if (params.getDtInicio() != null ) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dtInicio"), params.getDtInicio()));
            }

            if ( params.getDtTermino() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dtTermino"), params.getDtTermino()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
