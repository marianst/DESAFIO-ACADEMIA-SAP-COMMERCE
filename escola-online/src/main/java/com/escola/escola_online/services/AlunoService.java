package com.escola.escola_online.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escola.escola_online.dto.AlunoDTO;
import com.escola.escola_online.entities.Aluno;
import com.escola.escola_online.exceptions.DatabaseException;
import com.escola.escola_online.exceptions.ResourceNotFoundException;
import com.escola.escola_online.repositories.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAllPaged(PageRequest pageRequest){
		Page<Aluno> list = repository.findAll(pageRequest);
		
		return list.map(x -> new AlunoDTO(x));
	}

	
	@Transactional(readOnly = true)
	public AlunoDTO findById(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		Aluno entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AlunoDTO(entity);
	}

	@Transactional
	public AlunoDTO insert(AlunoDTO dto) {
		Aluno entity = new Aluno();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setDataCadastro(dto.getDataCadastro());
		entity = repository.save(entity);
		return new AlunoDTO(entity);

	}

	@Transactional
	public AlunoDTO update(Long id, AlunoDTO dto) {
		try {
			Aluno entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setDataCadastro(dto.getDataCadastro());
			return new AlunoDTO(entity);
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
