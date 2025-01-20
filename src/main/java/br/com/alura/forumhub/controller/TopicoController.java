package br.com.alura.forumhub.controller;


import br.com.alura.forumhub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico json){

        topicoRepository.save(new Topico(json));
    }

    @GetMapping
    public List<DadosListagemTopico> listar(){
        return topicoRepository.findAll().stream().map(DadosListagemTopico::new).toList();
    }

    @GetMapping("/{id}")
    public DadosListagemTopico listarPorId(@PathVariable Long id){
        return topicoRepository.findById(id).map(DadosListagemTopico::new).orElse(null);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTopico json){
        Optional<Topico> topico = topicoRepository.findById(json.id());
        System.out.println(topico);
        topico.ifPresent(value -> value.atualizarInformacoes(json));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        topico.ifPresent(value->topicoRepository.deleteById(id));
    }
}
