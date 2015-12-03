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
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQ_ESCOLHA", initialValue=1, allocationSize=1, sequenceName="seq_escolha")
public class Escolha implements Serializable {
	private static final long serialVersionUID = -4079670000868709598L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ESCOLHA")
	private int idEscolha;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="escolha_disciplina", 
			joinColumns = @JoinColumn(name="id_disciplina"),
			inverseJoinColumns = @JoinColumn(name="id_escolha"))
	private Collection<Escolha> escolhas;

	public int getIdEscolha() {
		return idEscolha;
	}

	public void setIdEscolha(int idEscolha) {
		this.idEscolha = idEscolha;
	}

	public Collection<Escolha> getEscolhas() {
		return escolhas;
	}

	public void setEscolhas(Collection<Escolha> escolhas) {
		this.escolhas = escolhas;
	}
	
	
	
}
