package com.dao;

import javax.ejb.Stateless;

import com.model.Pessoa;

@Stateless
public class PessoaDAO extends GenericDAO<Pessoa> {

	public PessoaDAO() {
		super(Pessoa.class);
	    }
	    
	    public void delete(Pessoa pessoa) {
	        super.delete(pessoa.getIdPessoa(), Pessoa.class);
	    }

}
