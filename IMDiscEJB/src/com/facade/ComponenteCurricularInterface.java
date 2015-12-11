package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.ComponenteCurricular;

@Local
public interface ComponenteCurricularInterface{

	public abstract void save(ComponenteCurricular componente);

	public abstract ComponenteCurricular update(ComponenteCurricular componente);
	
	public abstract void delete(ComponenteCurricular componente);

	public abstract ComponenteCurricular find(int entityID);

	public abstract List<ComponenteCurricular> findAll();
}
