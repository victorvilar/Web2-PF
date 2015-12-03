package com.dao;

import javax.ejb.Stateless;

import com.model.Curso;

@Stateless
public class CursoDAO extends GenericDAO<Curso> {

	public CursoDAO() {
		super(Curso.class);
	    }

	public void delete(Curso curso) {
		super.delete(curso.getIdCurso(), Curso.class);
	}

}
