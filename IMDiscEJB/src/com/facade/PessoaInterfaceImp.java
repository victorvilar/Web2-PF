package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.PessoaDAO;
import com.model.Pessoa;

@Stateless
public class PessoaInterfaceImp implements PessoaInterface{

	@EJB
	private PessoaDAO pessoaDAO;
	
	@Override
	public void save(Pessoa pessoa) {
		isPessoaWithAllData(pessoa);
		pessoaDAO.save(pessoa);
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		isPessoaWithAllData(pessoa);
		return pessoaDAO.update(pessoa);
	}
	
	@Override
	public void delete(Pessoa pessoa) {
		pessoaDAO.delete(pessoa);
	}

	@Override
	public Pessoa find(int entityID) {
		return pessoaDAO.find(entityID);
	}

	@Override
	public List<Pessoa> findAll() {
		return pessoaDAO.findAll();
	}
	
	private void isPessoaWithAllData(Pessoa pessoa){
		boolean hasError = false;
		
		if(pessoa == null){
			hasError = true;
		}
		
		if (pessoa.getNomePessoa() == null || "".equals(pessoa.getNomePessoa().trim())){
			hasError = true;
		}
		
		if(pessoa.getMatricula() <= 0){
			hasError = true;
		}
		
		if(pessoa.getUser() == null){
			hasError = true;
		}
		
		if (hasError){
			throw new IllegalArgumentException("The pessoa is missing data. Check the name and weight, they should have value.");
		}
	}
}
