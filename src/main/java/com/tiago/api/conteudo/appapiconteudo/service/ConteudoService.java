package com.tiago.api.conteudo.appapiconteudo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiago.api.conteudo.appapiconteudo.Publico;
import com.tiago.api.conteudo.appapiconteudo.Situacao;
import com.tiago.api.conteudo.appapiconteudo.dto.ConteudoCreateDto;
import com.tiago.api.conteudo.appapiconteudo.dto.ConteudoDto;
import com.tiago.api.conteudo.appapiconteudo.entity.Conteudo;
import com.tiago.api.conteudo.appapiconteudo.exception.RegraDeNegociosException;
import com.tiago.api.conteudo.appapiconteudo.repository.ConteudoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ConteudoService {
    @Autowired
    private final ConteudoRepository _conteudoRepository;
    private final ObjectMapper objectMapper;

    public Page<ConteudoDto> findAll(int page, int size, String central,
                                     Publico publico, Situacao situacao, Date dtinicio, Date dtfinal) {
        Pageable pageable = PageRequest.of(page, size);
        Integer pb = -1;
        Integer st = -1;
        Date dtIni;
        Date dtFim;

        if(publico!= null)
            pb = publico.getValor();

        if(situacao != null)
            st = situacao.getValor();

        return  _conteudoRepository.obterConteudos( pb, st, dtinicio, dtfinal, pageable);
    }

    public ConteudoDto create(ConteudoCreateDto conteudoCreateDto){
        Conteudo conteudoEntity = new Conteudo();

        conteudoEntity.setTitulo(conteudoCreateDto.getTitulo());
        conteudoEntity.setPublico(conteudoCreateDto.getPublico().getValor());
        conteudoEntity.setSituacao(conteudoCreateDto.getSituacao().getValor());
        conteudoEntity.setDtInicio(conteudoCreateDto.getDtInicio());
        conteudoEntity.setDtTermino(conteudoCreateDto.getDtFim());

        Conteudo conteudoCriado = _conteudoRepository.save(conteudoEntity);

        return findById(conteudoCriado.getID());
    }

    public ConteudoDto update(Integer id, ConteudoCreateDto conteudoCreateDto) throws RegraDeNegociosException {
        Conteudo conteudo = _conteudoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegociosException("Conteudo não localizado!"));

        conteudo.setTitulo(conteudoCreateDto.getTitulo());
        conteudo.setPublico(conteudoCreateDto.getPublico().getValor());
        conteudo.setSituacao(conteudoCreateDto.getSituacao().getValor());
        conteudo.setDtInicio(conteudoCreateDto.getDtInicio());
        conteudo.setDtTermino(conteudoCreateDto.getDtFim());

        Conteudo conteudoCriado = _conteudoRepository.save(conteudo);

        return findById(conteudoCriado.getID());
    }

    public ConteudoDto updateSituacao(Integer id, Situacao situacao) throws RegraDeNegociosException {
        Conteudo conteudo = _conteudoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegociosException("Conteudo não localizado!"));

        conteudo.setSituacao(situacao.getValor());

        Conteudo conteudoCriado = _conteudoRepository.save(conteudo);

        return findById(conteudoCriado.getID());
    }

    public void delete(Integer id) throws RegraDeNegociosException {
        Conteudo conteudo = _conteudoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegociosException("Conteudo não localizado!"));
        _conteudoRepository.delete(conteudo);
    }

    public ConteudoDto findById(Integer id){
        return  _conteudoRepository.obterConteudoPorId(id);
    }
}
