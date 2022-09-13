package com.tiago.api.conteudo.appapiconteudo.controller;

import com.tiago.api.conteudo.appapiconteudo.Publico;
import com.tiago.api.conteudo.appapiconteudo.Situacao;
import com.tiago.api.conteudo.appapiconteudo.dto.ConteudoCreateDto;
import com.tiago.api.conteudo.appapiconteudo.dto.ConteudoDto;
import com.tiago.api.conteudo.appapiconteudo.exception.RegraDeNegociosException;
import com.tiago.api.conteudo.appapiconteudo.service.ConteudoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/conteudo")
@RequiredArgsConstructor
@RestController
public class ConteudoController {

    @Autowired
    private ConteudoService _conteudoService;


    @GetMapping(params = {"page", "size"})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<ConteudoDto> Get(@RequestParam("page") int page,
                                 @RequestParam("size") int size,
                                 @RequestParam(required = false, value = "central") String central,
                                 @RequestParam(required = false, value = "publico") Publico publico,
                                 @RequestParam(required = false, value = "situacao") Situacao situacao,
                                 @RequestParam(required = false, value = "dtinicio") Date dtinicio,
                                 @RequestParam(required = false, value = "dtfinal") Date dtfinal
    ) {
        return _conteudoService.findAll(page, size, central, publico, situacao, dtinicio, dtfinal);
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public ConteudoDto GetPorId(@PathVariable("id") Integer id) {
        return _conteudoService.findById(id);
    }

    @PostMapping
    public ConteudoDto create(@RequestBody ConteudoCreateDto conteudoCreateDto){

        return _conteudoService.create(conteudoCreateDto);
    }

    @PutMapping
    @RequestMapping(value = "/atualizar-conteudo/{idConteudo}")
    public ConteudoDto update(@PathVariable("idConteudo") Integer id,
                              @RequestBody ConteudoCreateDto conteudoCreateDto) throws RegraDeNegociosException {

        return  _conteudoService.update(id, conteudoCreateDto);
    }

    @PutMapping
    @RequestMapping(value = "/alterar-situacao-conteudo/{idConteudo}")
    public ConteudoDto updateSituacao(@PathVariable("idConteudo") Integer id,
            @RequestParam Situacao situacao)throws RegraDeNegociosException {

        return  _conteudoService.updateSituacao(id, situacao);
    }

    @DeleteMapping("/delete-conteudo/{id}")
    public void delete(@PathVariable("id") Integer id)throws RegraDeNegociosException {
        _conteudoService.delete(id);

    }

}
