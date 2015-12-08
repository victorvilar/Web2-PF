package com.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_ESTRUTURACURRICULAR", initialValue = 1, allocationSize = 1, sequenceName = "seq_estruturacurricular")
public class EstruturaCurricular implements Serializable {
	private static final long serialVersionUID = -427632399345760954L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTRUTURACURRICULAR")
	private int idEstruturaCurricular;

	private String nomeEstrutura;

	@OneToMany(mappedBy = "estruturaCurricular")
	private Collection<Pessoa> pessoas;

	@ManyToOne
	@JoinColumn(name = "idCurso")
	private Curso curso;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "estruturacurricular_disciplina", joinColumns = @JoinColumn(name = "id_estruturacurricular") , inverseJoinColumns = @JoinColumn(name = "id_disciplina") )
	private Collection<Disciplina> disciplinas;

	public int getIdEstruturaCurricular() {
		return idEstruturaCurricular;
	}

	public void setIdEstruturaCurricular(int idEstruturaCurricular) {
		this.idEstruturaCurricular = idEstruturaCurricular;
	}

	public Collection<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Collection<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Collection<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
	public String getNomeEstrutura() {
		return nomeEstrutura;
	}

	
	public void setNomeEstrutura(String nomeEstrutura) {
		this.nomeEstrutura = nomeEstrutura;
	}

	
	public Curso getCurso() {
		return curso;
	}

	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
