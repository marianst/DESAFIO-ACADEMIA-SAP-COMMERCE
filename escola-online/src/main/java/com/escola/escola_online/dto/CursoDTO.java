package com.escola.escola_online.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.escola.escola_online.entities.Aluno;
import com.escola.escola_online.entities.Curso;

public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;    
	

	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	

	private Set<AlunoDTO> alunos = new HashSet<>();
	
	public CursoDTO() {

	}

	public CursoDTO(Long id, String nome, String descricao, LocalDate dataCriacao, Set<Curso> inscricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}
	
	public CursoDTO(Curso entity) {
		id = entity.getId();
		nome = entity.getNome();
		descricao = entity.getDescricao();
		dataCriacao = entity.getDataCriacao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setEmail(String email) {
		this.descricao = email;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCadastro(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
