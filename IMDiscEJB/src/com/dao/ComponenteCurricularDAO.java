package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.model.ComponenteCurricular;

@Stateless
public class ComponenteCurricularDAO extends GenericDAO<ComponenteCurricular> {

	public ComponenteCurricularDAO() {
		super(ComponenteCurricular.class);
	    }

	public void delete(ComponenteCurricular componente) {
		super.delete(componente.getIdComponenteCurricular(), ComponenteCurricular.class);
	}

	public List<ComponenteCurricular> listaComponentesDeEstrutura(int id_estruturacurricular){
       javax.persistence.Query query = em.createQuery("SELECT c FROM ComponenteCurricular c WHERE id_estruturacurricular = :id_estruturacurricular");
        query.setParameter("id_estruturacurricular", id_estruturacurricular);
        List<ComponenteCurricular> listaComponenteCurricular = ((javax.persistence.Query) query).getResultList();
		
		return listaComponenteCurricular;
	}
	
}