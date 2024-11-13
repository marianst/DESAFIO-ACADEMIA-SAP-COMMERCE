package com.escola.escola_online.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_inscricao")
public class Inscricao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno alunoID;
	
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso cursoID;
	

	private LocalDate dataInscricao;
	


	public Inscricao() {
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Aluno getAlunoID() {
		return alunoID;
	}



	public void setAlunoID(Aluno alunoID) {
		this.alunoID = alunoID;
	}



	public Curso getCursoID() {
		return cursoID;
	}



	public void setCursoID(Curso cursoID) {
		this.cursoID = cursoID;
	}



	public LocalDate getDataInscricao() {
		return dataInscricao;
	}



	public void setDataInscricao(LocalDate dataInscricao) {
		this.dataInscricao = dataInscricao;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	



	
	
	
	

}
