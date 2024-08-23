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

    // GET /conteudos - Retorna todos os conteúdos
    @GetMapping
    public ResponseEntity<List<Conteudo>> listarTodos() {
        List<Conteudo> conteudos = conteudoService.buscarTodosConteudos();
        return ResponseEntity.ok(conteudos);
    }

    // GET /conteudos/{id} - Retorna um conteúdo específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Conteudo> buscarPorId(@PathVariable Long id) {
        Conteudo conteudo = conteudoService.buscarConteudoPorId(id);
        return ResponseEntity.ok(conteudo);
    }

    // POST /conteudos - Cria um novo conteúdo
    @PostMapping
    public ResponseEntity<Conteudo> criarConteudo(@RequestBody Conteudo conteudo) {
        Conteudo novoConteudo = conteudoService.salvarConteudo(conteudo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConteudo);
    }

    // PUT /conteudos/{id} - Atualiza um conteúdo existente
    @PutMapping("/{id}")
    public ResponseEntity<Conteudo> atualizarConteudo(@PathVariable Long id, @RequestBody Conteudo conteudoAtualizado) {
        Conteudo conteudo = conteudoService.atualizarConteudo(id, conteudoAtualizado);
        return ResponseEntity.ok(conteudo);
    }

    // DELETE /conteudos/{id} - Deleta um conteúdo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConteudo(@PathVariable Long id) {
        conteudoService.deletarConteudo(id);
        return ResponseEntity.noContent().build();
    }
}
