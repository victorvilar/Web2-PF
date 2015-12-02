package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.facade.DisciplinaInterface;
import com.model.Disciplina;
import com.model.Disciplina;

@ManagedBean(name = "DisciplinaMB")
@SessionScoped
public class DisciplinaMB implements Serializable {
	private static final long serialVersionUID = 215121400308620706L;

	private Disciplina disciplina;
	
	@EJB
	private DisciplinaInterface disciplinaInterface;
	
	private static final String CREATE_DOG = "createDisciplina";
	private static final String DELETE_DOG = "deleteDisciplina"; 
	private static final String UPDATE_DOG = "updateDisciplina";
	private static final String LIST_ALL_DOGS = "listAllDisciplinas";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	public Disciplina getDisciplina() {
		
		if(disciplina == null){
			disciplina = new Disciplina();
		}
		
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getAllDisciplinas() {
		return disciplinaInterface.findAll();
	}

	public String updateDisciplinaStart(){
		return UPDATE_DOG;
	}
	
	public String updateDisciplinaEnd(){
		try {
			disciplinaInterface.update(disciplina);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the weight is above 0 or call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_DOGS;
	}
	
	public String deleteDisciplinaStart(){
		return DELETE_DOG;
	}
	
	public String deleteDisciplinaEnd(){
		try {
			disciplinaInterface.delete(disciplina);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_DOGS;
	}
	
	public String createDisciplinaStart(){
		return CREATE_DOG;
	}
	
	public String createDisciplinaEnd(){
		try {
			disciplinaInterface.save(disciplina);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the weight is above 0 or call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_DOGS;
	}
	
	public String listAllDisciplinas(){
		return LIST_ALL_DOGS;
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
