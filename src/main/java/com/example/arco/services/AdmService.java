package com.example.arco.services;



import com.example.arco.model.adm;
import com.example.arco.repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmService {

    @Autowired
    private AdmRepository admRepository;

  
    public adm criarAdm(adm novoAdm) {
        return admRepository.save(novoAdm);
    }


    public List<adm> buscarTodosAdms() {
        return admRepository.findAll();
    }

    public Optional<adm> buscarAdmPorId(Long id) {
        return admRepository.findById(id);
    }


    public Optional<adm> atualizarAdm(Long id, adm admAtualizado) {
        return admRepository.findById(id).map(existingAdm -> {
            admAtualizado.setId(id);
            return admRepository.save(admAtualizado);
        });
    }

  
    public boolean deletarAdm(Long id) {
        if (admRepository.existsById(id)) {
            admRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
