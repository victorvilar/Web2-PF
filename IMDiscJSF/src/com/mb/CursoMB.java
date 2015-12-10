package com.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.facade.CursoInterface;
import com.model.Curso;

@ManagedBean
@RequestScoped
public class CursoMB {
	
	@EJB
	private CursoInterface cursoInterface;
	
	private static final String CREATE_CURSO = "createCurso";
	private static final String DELETE_CURSO = "deleteCurso"; 
	private static final String UPDATE_CURSO = "updateCurso";
	private static final String LIST_ALL_CURSOS = "listAllCursos";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	private Curso curso;

	public Curso getCurso() {
		
		if(curso == null){
			curso = new Curso();
		}
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getAllCursos() {
		return cursoInterface.findAll();
	}

	public String updateCursoStart(){
		return UPDATE_CURSO;
	}
	
	public String updateCursoEnd(){
		try {
			cursoInterface.update(curso);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm1");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_CURSOS;
	}
	
	public String deleteCursoStart(){
		return DELETE_CURSO;
	}
	
	public String deleteCursoEnd(){
		try {
			cursoInterface.delete(curso);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM2");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_CURSOS;
	}
	
	public String createCursoStart(){
		return CREATE_CURSO;
	}
	
	public String createCursoEnd(){
		try {
			cursoInterface.save(curso);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm3");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_CURSOS;
	}
	
	public String listAllCursos(){
		return LIST_ALL_CURSOS;
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
