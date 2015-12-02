package com.dao;

import javax.ejb.Stateless;

import com.model.Escolha;

@Stateless
public class EscolhaDAO extends GenericDAO<Escolha> {

	public EscolhaDAO() {
		super(Escolha.class);
	    }

	public void delete(Escolha escolha) {
		super.delete(escolha.getIdEscolha(), Escolha.class);
	}

}
