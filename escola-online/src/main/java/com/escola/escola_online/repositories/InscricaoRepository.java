package com.escola.escola_online.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola_online.entities.Inscricao;


public interface InscricaoRepository extends JpaRepository <Inscricao, Long> {
	
	Optional<Inscricao> findById(Long id);


}
