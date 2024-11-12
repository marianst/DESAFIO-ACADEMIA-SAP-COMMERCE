package com.escola.escola_online.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola_online.entities.Curso;


public interface CursoRepository extends JpaRepository <Curso, Long> {
	
	Optional<Curso> findById(Long id);


}
