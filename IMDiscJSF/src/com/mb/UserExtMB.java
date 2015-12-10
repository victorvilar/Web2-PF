package com.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.facade.UserFacade;
import com.model.User;

@ManagedBean
@RequestScoped
public class UserExtMB {
	
	@EJB
	private UserFacade userFacade;
	
	private static final String CREATE_USER = "createUser";
	private static final String DELETE_USER = "deleteUser"; 
	private static final String UPDATE_USER = "updateUser";
	private static final String LIST_ALL_USERS = "listAllUsers";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	private User user;
	
	//CRUD
	public User getUser() {	
		if(user == null){
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getAllusers() {
		return userFacade.findAll();
	}

	public String updateUserStart(){
		return UPDATE_USER;
	}
	
	public String updateUserEnd(){
		try {
			userFacade.update(user);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Nao foi possível atualizar o user");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_USERS;
	}
	
	public String deleteUserStart(){
		System.out.println("ID DO CARA: ------------------ "  + user.getId());
		return DELETE_USER;
	}
	
	public String deleteUserEnd(){
		try {
			System.out.println("ID DO CARA: ------------------ "  + user.getId());
			userFacade.delete(user);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_USERS;
	}
	
	public String createUserStart(){
		return CREATE_USER;
	}
	
	public String createUserEnd(){
		try {
			userFacade.save(user);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the weight is above 0 or call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_USERS;
	}
	
	public String listAllUsers(){
		return LIST_ALL_USERS;
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
	
	public void printTexto(){
		System.out.println();
		System.out.println("FUNCAO PRINT");
		System.out.println("ID: " + user.getId());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Nome: " + user.getName());
		System.out.println("Pass: " + user.getPassword());
		System.out.println("Role: " + user.getRole());
		System.out.println("Matricula: " + user.getMatricula());
		System.out.println();
	}
	
}