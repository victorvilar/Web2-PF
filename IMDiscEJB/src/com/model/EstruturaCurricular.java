package com.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@OneToMany(mappedBy = "estruturaCurricular", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<User> users;

	@ManyToOne
	@JoinColumn(name = "idCurso")
	private Curso curso;

	@OneToMany(mappedBy = "estruturaCurricular", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<ComponenteCurricular> componentesCurriculares;

	// GETTERS AND SETTERS

	public int getIdEstruturaCurricular() {
		return idEstruturaCurricular;
	}

	public void setIdEstruturaCurricular(int idEstruturaCurricular) {
		this.idEstruturaCurricular = idEstruturaCurricular;
	}

	public String getNomeEstrutura() {
		return nomeEstrutura;
	}

	public void setNomeEstrutura(String nomeEstrutura) {
		this.nomeEstrutura = nomeEstrutura;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Collection<ComponenteCurricular> getComponentesCurriculares() {
		return componentesCurriculares;
	}

	public void setComponentesCurriculares(Collection<ComponenteCurricular> componentesCurriculares) {
		this.componentesCurriculares = componentesCurriculares;
	}

}
