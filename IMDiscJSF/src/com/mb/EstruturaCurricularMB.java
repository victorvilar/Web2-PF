package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.facade.EstruturaCurricularInterface;
import com.model.EstruturaCurricular;

@ManagedBean(name = "EstruturaCurricularMB")
@SessionScoped
public class EstruturaCurricularMB implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187732078408137806L;

	private EstruturaCurricular estruturacurricular;
	
	@EJB
	private EstruturaCurricularInterface estruturacurricularInterface;
	
	private static final String CREATE_ESTRUTURA_CURRICULAR = "createEstruturaCurricular";
	private static final String DELETE_ESTRUTURA_CURRICULAR = "deleteEstruturaCurricular"; 
	private static final String UPDATE_ESTRUTURA_CURRICULAR = "updateEstruturaCurricular";
	private static final String LIST_ALL_ESTRUTURA_CURRICULARES = "listAllEstruturaCurriculares";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	public EstruturaCurricular getEstruturaCurricular() {
		
		if(estruturacurricular == null){
			estruturacurricular = new EstruturaCurricular();
		}
		return estruturacurricular;
	}

	public void setEstruturaCurricular(EstruturaCurricular estruturacurricular) {
		this.estruturacurricular = estruturacurricular;
	}

	public List<EstruturaCurricular> getAllEstruturaCurriculars() {
		return estruturacurricularInterface.findAll();
	}

	public String updateEstruturaCurricularStart(){
		return UPDATE_ESTRUTURA_CURRICULAR;
	}
	
	public String updateEstruturaCurricularEnd(){
		try {
			estruturacurricularInterface.update(estruturacurricular);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_ESTRUTURA_CURRICULARES;
	}
	
	public String deleteEstruturaCurricularStart(){
		return DELETE_ESTRUTURA_CURRICULAR;
	}
	
	public String deleteEstruturaCurricularEnd(){
		try {
			estruturacurricularInterface.delete(estruturacurricular);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_ESTRUTURA_CURRICULARES;
	}
	
	public String createEstruturaCurricularStart(){
		return CREATE_ESTRUTURA_CURRICULAR;
	}
	
	public String createEstruturaCurricularEnd(){
		try {
			estruturacurricularInterface.save(estruturacurricular);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_ESTRUTURA_CURRICULARES;
	}
	
	public String listAllEstruturaCurriculares(){
		return LIST_ALL_ESTRUTURA_CURRICULARES;
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
