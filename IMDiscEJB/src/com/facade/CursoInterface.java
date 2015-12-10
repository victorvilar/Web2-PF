package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Curso;

@Local
public interface CursoInterface {

	public abstract void save(Curso curso);

	public abstract Curso update(Curso curso);
	
	public abstract void delete(Curso curso);

	public abstract Curso find(int entityID);

	public abstract List<Curso> findAll();
}
