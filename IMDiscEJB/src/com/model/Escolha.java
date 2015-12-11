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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_ESCOLHA", initialValue = 1, allocationSize = 1, sequenceName = "seq_escolha")
public class Escolha implements Serializable {
	private static final long serialVersionUID = -4079670000868709598L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESCOLHA")
	private int idEscolha;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "escolha_componenteCurricular", joinColumns = @JoinColumn(name = "id_escolha") , inverseJoinColumns = @JoinColumn(name = "id_componente") )
	private Collection<ComponenteCurricular> componenteCurricular;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser")
	private User user;	

	private String semestreEscolha;

	public int getIdEscolha() {
		return idEscolha;
	}

	public String getSemestreEscolha() {
		return semestreEscolha;
	}

	public void setSemestreEscolha(String semestreEscolha) {
		this.semestreEscolha = semestreEscolha;
	}

	public void setIdEscolha(int idEscolha) {
		this.idEscolha = idEscolha;
	}
	
	
	public Collection<ComponenteCurricular> getComponenteCurricular() {
		return componenteCurricular;
	}

	public void setComponenteCurricular(Collection<ComponenteCurricular> componenteCurricular) {
		this.componenteCurricular = componenteCurricular;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
