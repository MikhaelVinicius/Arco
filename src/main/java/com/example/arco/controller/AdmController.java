package com.example.arco.controller;

import com.example.arco.model.adm;
import com.example.arco.repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmRepository admRepository;

    // Criar um novo adm
    @PostMapping
    public ResponseEntity<adm> criarAdm(@RequestBody adm novoAdm) {
        adm admSalvo = admRepository.save(novoAdm);
        return new ResponseEntity<>(admSalvo, HttpStatus.CREATED);
    }

    // Buscar todos os adms
    @GetMapping
    public ResponseEntity<List<adm>> buscarTodosAdms() {
        List<adm> adms = admRepository.findAll();
        return new ResponseEntity<>(adms, HttpStatus.OK);
    }

    // Buscar adm por ID
    @GetMapping("/{id}")
    public ResponseEntity<adm> buscarAdmPorId(@PathVariable Long id) {
        Optional<adm> admOpt = admRepository.findById(id);
        if (admOpt.isPresent()) {
            return new ResponseEntity<>(admOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Atualizar um adm existente
    @PutMapping("/{id}")
    public ResponseEntity<adm> atualizarAdm(@PathVariable Long id, @RequestBody adm admAtualizado) {
        if (admRepository.existsById(id)) {
            admAtualizado.setId(id); // Garante que o ID é o mesmo do que está sendo atualizado
            adm admSalvo = admRepository.save(admAtualizado);
            return new ResponseEntity<>(admSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar um adm por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdm(@PathVariable Long id) {
        if (admRepository.existsById(id)) {
            admRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
