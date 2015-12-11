package com.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_DISCIPLINA", initialValue = 1, allocationSize = 1, sequenceName = "seq_disciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = -1982314173258042136L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DISCIPLINA")
	private int idDisciplina;
	@Column(nullable = false)
	private String nomeDisciplina;
	@Column(nullable = false)
	private int cargaHoraria;
	@Column(nullable = false)
	private String codigo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "escolha_disciplina", joinColumns = @JoinColumn(name = "id_disciplina") , inverseJoinColumns = @JoinColumn(name = "id_escolha") )
	private Collection<Escolha> escolhas;

	@OneToMany(mappedBy = "disciplina")
	private Collection<ComponenteCurricular> componentesCurriculares;

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Collection<Escolha> getEscolhas() {
		return escolhas;
	}

	public void setEscolhas(Collection<Escolha> escolhas) {
		this.escolhas = escolhas;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public Collection<ComponenteCurricular> getComponentesCurriculares() {
		return componentesCurriculares;
	}

	
	public void setComponentesCurriculares(Collection<ComponenteCurricular> componentesCurriculares) {
		this.componentesCurriculares = componentesCurriculares;
	}

}
