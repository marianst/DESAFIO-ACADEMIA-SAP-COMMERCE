package com.escola.escola_online.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.escola.escola_online.entities.Aluno;
import com.escola.escola_online.entities.Curso;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;    
	

	private Long id;
	private String nome;
	private String email;
	private LocalDate dataCadastro;
	

	private Set<CursoDTO> cursos = new HashSet<>();
	
	public AlunoDTO() {

	}

	public AlunoDTO(Long id, String nome, String email, LocalDate dataCadastro, Set<Curso> inscricao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}
	
	public AlunoDTO(Aluno entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		dataCadastro = entity.getDataCadastro();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
