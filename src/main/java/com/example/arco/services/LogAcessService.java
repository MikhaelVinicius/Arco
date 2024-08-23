package com.example.arco.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.arco.model.LogAcess;
import com.example.arco.repository.logAcessRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LogAcessService {

    @Autowired
    private logAcessRepository logAcessRepository;

    public LogAcess salvarLog(LogAcess logAcess) {
        return logAcessRepository.save(logAcess);
    }

    public Optional<LogAcess> buscarPorId(Long id) {
        return logAcessRepository.findById(id);
    }

    public List<LogAcess> buscarTodos() {
        return logAcessRepository.findAll();
    }

    public void deletarPorId(Long id) {
        logAcessRepository.deleteById(id);
    }
}
