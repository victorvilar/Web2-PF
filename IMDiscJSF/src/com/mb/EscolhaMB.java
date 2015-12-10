package com.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.facade.EscolhaInterface;
import com.model.Escolha;

@ManagedBean
@RequestScoped
public class EscolhaMB {
	
	@EJB
	private EscolhaInterface escolhaInterface;
	
	
	private static final String CREATE_ESCOLHA = "createEscolha";
	private static final String DELETE_ESCOLHA = "deleteEscolha"; 
	private static final String UPDATE_ESCOLHA = "updateEscolha";
	private static final String LIST_ALL_ESCOLHAS = "listAllEscolhas";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	private Escolha escolha;	

	public Escolha getEscolha() {
		
		if(escolha == null){
			escolha = new Escolha();
		}
		return escolha;
	}

	public void setEscolha(Escolha escolha) {
		this.escolha = escolha;
	}

	public List<Escolha> getAllEscolhas() {
		return escolhaInterface.findAll();
	}

	public String updateEscolhaStart(){
		return UPDATE_ESCOLHA;
	}
	
	public String updateEscolhaEnd(){
		try {
			escolhaInterface.update(escolha);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm1");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_ESCOLHAS;
	}
	
	public String deleteEscolhaStart(){
		return DELETE_ESCOLHA;
	}
	
	public String deleteEscolhaEnd(){
		try {
			escolhaInterface.delete(escolha);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM2");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_ESCOLHAS;
	}
	
	public String createEscolhaStart(){
		return CREATE_ESCOLHA;
	}
	
	public String createEscolhaEnd(){
		try {
			escolhaInterface.save(escolha);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm3");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_ESCOLHAS;
	}
	
	public String listAllEscolhas(){
		return LIST_ALL_ESCOLHAS;
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
 
