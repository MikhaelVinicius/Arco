package com.example.arco.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arco.model.adm;
import com.example.arco.model.Conteudo;

import java.util.List;


public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {


}


