package com.example.arco.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.arco.model.LogAcess;
import com.example.arco.services.LogAcessService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class LogAcessController {

    @Autowired
    private LogAcessService logAcessService;

    @PostMapping
    public ResponseEntity<LogAcess> criarLog(@RequestBody LogAcess logAcess) {
        LogAcess novoLog = logAcessService.salvarLog(logAcess);
        return ResponseEntity.ok(novoLog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogAcess> buscarLogPorId(@PathVariable Long id) {
        Optional<LogAcess> logAcess = logAcessService.buscarPorId(id);
        return logAcess.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LogAcess>> buscarTodosLogs() {
        List<LogAcess> logs = logAcessService.buscarTodos();
        return ResponseEntity.ok(logs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLog(@PathVariable Long id) {
        logAcessService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
