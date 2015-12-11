package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_COMPONENTE_CURRICULAR", initialValue = 1, allocationSize = 1, sequenceName = "seq_componente_curricular")
public class ComponenteCurricular {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMPONENTE_CURRICULAR")
	private int idComponenteCurricular;

	private int nivel;
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "id_estruturaCurricular")
	private EstruturaCurricular estruturaCurricular;

	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;

	public int getIdComponenteCurricular() {
		return idComponenteCurricular;
	}

	public void setIdComponenteCurricular(int idComponenteCurricular) {
		this.idComponenteCurricular = idComponenteCurricular;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EstruturaCurricular getEstruturaCurricular() {
		return estruturaCurricular;
	}

	public void setEstruturaCurricular(EstruturaCurricular estruturaCurricular) {
		this.estruturaCurricular = estruturaCurricular;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
