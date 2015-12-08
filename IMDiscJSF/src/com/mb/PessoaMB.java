package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.facade.PessoaInterface;
import com.model.Pessoa;
import com.model.Pessoa;

@ManagedBean(name = "PessoaMB")
@SessionScoped
public class PessoaMB implements Serializable {
	
	private static final long serialVersionUID = -329216827348989761L;
	
	private static final String CREATE_PESSOA = "createPessoa";
	private static final String DELETE_PESSOA = "deletePessoa"; 
	private static final String UPDATE_PESSOA = "updatePessoa";
	private static final String LIST_ALL_PESSOAS = "listAllPessoas";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	private Pessoa pessoa;
	
	@EJB
	private PessoaInterface pessoaInterface;
	
	public Pessoa getPessoa() {
		
		if(pessoa == null){
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getAllPessoas() {
		return pessoaInterface.findAll();
	}

	public String updatePessoaStart(){
		return UPDATE_PESSOA;
	}
	
	public String updatePessoaEnd(){
		try {
			pessoaInterface.update(pessoa);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Error. Call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_PESSOAS;
	}
	
	public String deletePessoaStart(){
		return DELETE_PESSOA;
	}
	
	public String deletePessoaEnd(){
		try {
			pessoaInterface.delete(pessoa);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}			
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_PESSOAS;
	}
	
	public String createPessoaStart(){
		return CREATE_PESSOA;
	}
	
	public String createPessoaEnd(){
		try {
			pessoaInterface.save(pessoa);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Error. Call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_PESSOAS;
	}
	
	public String listAllPessoas(){
		return LIST_ALL_PESSOAS;
	}
	
	private void sendInfoMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	private void sendErrorMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}

	
}
