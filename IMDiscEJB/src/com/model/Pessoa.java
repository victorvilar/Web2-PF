package com.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_PESSOA", initialValue = 1, allocationSize = 1, sequenceName = "seq_pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = -3379758744266283863L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
	private int idPessoa;

	@Column(nullable = false)
	private String nomePessoa;
	
	private long matricula;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private User user;

	@OneToMany(mappedBy = "pessoa")
	private Collection<Escolha> escolhas;

	@ManyToOne
	@JoinColumn(name = "id_estruturaCurricular")
	private EstruturaCurricular estruturaCurricular;

	//Getters and Setters
	
	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public EstruturaCurricular getEstruturaCurricular() {
		return estruturaCurricular;
	}

	public void setEstruturaCurricular(EstruturaCurricular estruturaCurricular) {
		this.estruturaCurricular = estruturaCurricular;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Collection<Escolha> getEscolhas() {
		return escolhas;
	}
	
	public void setEscolhas(Collection<Escolha> escolhas) {
		this.escolhas = escolhas;
	}

}
