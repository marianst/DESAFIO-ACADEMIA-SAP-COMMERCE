package com.escola.escola_online.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escola.escola_online.entities.Inscricao;
import com.escola.escola_online.exceptions.DatabaseException;
import com.escola.escola_online.exceptions.ResourceNotFoundException;
import com.escola.escola_online.repositories.InscricaoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InscricaoService {
	
	@Autowired
	private InscricaoRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<Inscricao> findAllPaged(PageRequest pageRequest){
		Page<Inscricao> list = repository.findAll(pageRequest);
		
		return list;
	}

	
	@Transactional(readOnly = true)
	public Inscricao findById(Long id) {
		Optional<Inscricao> obj = repository.findById(id);
		Inscricao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}

	@Transactional
	public Inscricao insert(Inscricao inscricao) {
		Inscricao entity = new Inscricao();
		entity.setAlunoID(inscricao.getAlunoID());
		entity.setCursoID(inscricao.getCursoID());
		entity.setDataInscricao(inscricao.getDataInscricao());
		entity = repository.save(entity);
		return entity;

	}

	@Transactional
	public Inscricao update(Long id, Inscricao inscricao) {
		try {
			Inscricao entity = repository.getOne(id);
			entity.setAlunoID(inscricao.getAlunoID());
			entity.setCursoID(inscricao.getCursoID());
			entity.setDataInscricao(inscricao.getDataInscricao());
			return entity;
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
