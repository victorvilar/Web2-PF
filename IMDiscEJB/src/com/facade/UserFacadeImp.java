package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.UserDAO;
import com.model.User;

@Stateless
public class UserFacadeImp implements UserFacade {

	@EJB 
	private UserDAO userDAO;
	
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}

	@Override
	public void save(User user) {
		isUserWithAllData(user);
		userDAO.save(user);
	}

	@Override
	public User update(User user) {
		isUserWithAllData(user);
		return userDAO.update(user);
	}
	
	@Override
	public void delete(User user) {
		
		System.out.println();
		System.out.println("Tentando deletar:");
		System.out.println("ID: " + user.getId());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Nome: " + user.getName());
		System.out.println("Pass: " + user.getPassword());
		System.out.println("Role: " + user.getRole());
		System.out.println("Matricula: " + user.getMatricula());
		System.out.println();
		
		
		
		userDAO.delete(user);
	}
	
	private void isUserWithAllData(User user){
		boolean hasError = false;
		
		System.out.println();
		System.out.println("Email: " + user.getEmail());
		System.out.println("Nome: " + user.getName());
		System.out.println("Pass: " + user.getPassword());
		System.out.println("Role: " + user.getRole());
		System.out.println("Matricula: " + user.getMatricula());
		System.out.println();
		
		if (user.getPassword() == null || "".equals(user.getPassword().trim())){
			hasError = true;
		}
		
		if (user.getEmail() == null || "".equals(user.getEmail().trim())){
			hasError = true;
		}
		
		if (hasError){
			throw new IllegalArgumentException("The user is missing data.");
		}
	}

	@Override
	public User find(int entityID) {
		return userDAO.find(entityID);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}


}