package com.dao;

import javax.ejb.Stateless;

import com.model.EstruturaCurricular;
@Stateless
public class EstruturaCurricularDAO extends GenericDAO<EstruturaCurricular> {

	public EstruturaCurricularDAO() {
		super(EstruturaCurricular.class);
	    }
	    
	    public void delete(EstruturaCurricular estrutura) {
	        super.delete(estrutura.getIdEstruturaCurricular(), EstruturaCurricular.class);
	    }

}
