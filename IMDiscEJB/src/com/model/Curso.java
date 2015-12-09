package com.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQ_CURSO", initialValue=1, allocationSize=1, sequenceName="seq_curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = -2795550003633216601L;
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CURSO")
    private int idCurso;
	private String nomeCurso;
	private int cargaHoraria;
	
	// 1 -> *
	@OneToMany(mappedBy="curso") 
	private Collection<EstruturaCurricular> estruturasCurriculares;

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

//	public Collection<EstruturaCurricular> getEstruturasCurriculares() {
//		return estruturasCurriculares;
//	}
//
//	public void setEstruturasCurriculares(Collection<EstruturaCurricular> estruturasCurriculares) {
//		this.estruturasCurriculares = estruturasCurriculares;
//	}

}
