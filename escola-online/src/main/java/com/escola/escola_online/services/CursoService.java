package com.escola.escola_online.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escola.escola_online.dto.CursoDTO;
import com.escola.escola_online.entities.Curso;
import com.escola.escola_online.exceptions.DatabaseException;
import com.escola.escola_online.exceptions.ResourceNotFoundException;
import com.escola.escola_online.repositories.CursoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<CursoDTO> findAllPaged(PageRequest pageRequest){
		Page<Curso> list = repository.findAll(pageRequest);
		
		return list.map(x -> new CursoDTO(x));
	}

	
	@Transactional(readOnly = true)
	public CursoDTO findById(Long id) {
		Optional<Curso> obj = repository.findById(id);
		Curso entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new CursoDTO(entity);
	}

	@Transactional
	public CursoDTO insert(CursoDTO dto) {
		Curso entity = new Curso();
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setDataCriacao(dto.getDataCriacao());
		entity = repository.save(entity);
		return new CursoDTO(entity);

	}

	@Transactional
	public CursoDTO update(Long id, CursoDTO dto) {
		try {
			Curso entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setDescricao(dto.getDescricao());
			entity.setDataCriacao(dto.getDataCriacao());
			return new CursoDTO(entity);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	public void delete(Long id) {

		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	

}
