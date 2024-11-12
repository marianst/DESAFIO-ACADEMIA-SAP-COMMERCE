package com.escola.escola_online.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola_online.entities.Aluno;


public interface AlunoRepository extends JpaRepository <Aluno, Long> {
	
	Optional<Aluno> findById(Long id);


}
