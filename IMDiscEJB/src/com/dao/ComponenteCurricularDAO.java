package com.dao;

import javax.ejb.Stateless;

import com.model.ComponenteCurricular;

@Stateless
public class ComponenteCurricularDAO extends GenericDAO<ComponenteCurricular> {

	public ComponenteCurricularDAO() {
		super(ComponenteCurricular.class);
	    }

	public void delete(ComponenteCurricular componente) {
		super.delete(componente.getIdComponenteCurricular(), ComponenteCurricular.class);
	}

}