package com.example.arco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.arco.model.Conteudo;
import com.example.arco.services.ConteudoService;

import java.util.List;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

    @Autowired
    private ConteudoService conteudoService;

    
    @GetMapping
    public ResponseEntity<List<Conteudo>> listarTodos() {
        List<Conteudo> conteudos = conteudoService.buscarTodosConteudos();
        return ResponseEntity.ok(conteudos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conteudo> buscarPorId(@PathVariable Long id) {
        Conteudo conteudo = conteudoService.buscarConteudoPorId(id);
        return ResponseEntity.ok(conteudo);
    }

    @PostMapping
    public ResponseEntity<Conteudo> criarConteudo(@RequestBody Conteudo conteudo) {
        Conteudo novoConteudo = conteudoService.salvarConteudo(conteudo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConteudo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conteudo> atualizarConteudo(@PathVariable Long id, @RequestBody Conteudo conteudoAtualizado) {
        Conteudo conteudo = conteudoService.atualizarConteudo(id, conteudoAtualizado);
        return ResponseEntity.ok(conteudo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConteudo(@PathVariable Long id) {
        conteudoService.deletarConteudo(id);
        return ResponseEntity.noContent().build();
    }
}
