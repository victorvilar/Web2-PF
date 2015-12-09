package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.EstruturaCurricular;

@Local
public interface EstruturaCurricularInterface {
	public abstract void save(EstruturaCurricular estrutura);

	public abstract EstruturaCurricular update(EstruturaCurricular estrutura);
	
	public abstract void delete(EstruturaCurricular estrutura);

	public abstract EstruturaCurricular find(int entityID);

	public abstract List<EstruturaCurricular> findAll();
}
