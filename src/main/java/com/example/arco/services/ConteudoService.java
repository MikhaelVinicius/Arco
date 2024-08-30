package com.example.arco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.arco.model.Conteudo;
import com.example.arco.repository.ConteudoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConteudoService {

    @Autowired
    private ConteudoRepository conteudoRepository;

 
    public Conteudo salvarConteudo(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

   
    public Conteudo atualizarConteudo(Long id, Conteudo conteudoAtualizado) {
        Optional<Conteudo> conteudoExistente = conteudoRepository.findById(id);
        if (conteudoExistente.isPresent()) {
            Conteudo conteudo = conteudoExistente.get();
            conteudo.setNome(conteudoAtualizado.getNome());
            conteudo.setDescricao(conteudoAtualizado.getDescricao());
            conteudo.setEndereco(conteudoAtualizado.getEndereco());
            conteudo.setNumero(conteudoAtualizado.getNumero());
            conteudo.setEmail(conteudoAtualizado.getEmail());
            conteudo.setHorario_de_funcionamento(conteudoAtualizado.getHorario_de_funcionamento());
            conteudo.setHorarioAbertura(conteudoAtualizado.getHorarioAbertura());
            conteudo.setHorarioFechamento(conteudoAtualizado.getHorarioFechamento());
            conteudo.setCriador(conteudoAtualizado.getCriador());
            conteudo.setImagens(conteudoAtualizado.getImagens());
            conteudo.setTipo(conteudoAtualizado.getTipo());
            return conteudoRepository.save(conteudo);
        } else {
            throw new RuntimeException("Conteúdo não encontrado com id: " + id);
        }
    }

    
    public Conteudo buscarConteudoPorId(Long id) {
        return conteudoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conteúdo não encontrado com id: " + id));
    }


    public List<Conteudo> buscarTodosConteudos() {
        return conteudoRepository.findAll();
    }

    public void deletarConteudo(Long id) {
        if (conteudoRepository.existsById(id)) {
            conteudoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Conteúdo não encontrado com id: " + id);
        }
    }

    
}
