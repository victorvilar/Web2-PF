package com.model;

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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@NamedQuery(name="User.findUserByEmail", query="select u from User u where u.email = :email")
public class User {
	
	public static final String FIND_BY_EMAIL = "User.findUserByEmail";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String email;
	private String password;
	private String name;
	private String role;
	@Column(unique = true)	
	private long matricula;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Escolha> escolhas;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estruturaCurricular")
	private EstruturaCurricular estruturaCurricular;
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User){
			User user = (User) obj;
			return user.getEmail().equals(getEmail());
		}
		
		return false;
	}

	
	public long getMatricula() {
		return matricula;
	}

	
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	
	public Collection<Escolha> getEscolhas() {
		return escolhas;
	}

	
	public void setEscolhas(Collection<Escolha> escolhas) {
		this.escolhas = escolhas;
	}

	
	public EstruturaCurricular getEstruturaCurricular() {
		return estruturaCurricular;
	}

	
	public void setEstruturaCurricular(EstruturaCurricular estruturaCurricular) {
		this.estruturaCurricular = estruturaCurricular;
	}

	
}
