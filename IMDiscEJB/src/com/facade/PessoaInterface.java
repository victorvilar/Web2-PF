package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Pessoa;

@Local
public interface PessoaInterface {
	public abstract void save(Pessoa Pessoa);

	public abstract Pessoa update(Pessoa Pessoa);
	
	public abstract void delete(Pessoa Pessoa);

	public abstract Pessoa find(int entityID);

	public abstract List<Pessoa> findAll();
	
}
