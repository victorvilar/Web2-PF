package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.User;

@Local
public interface UserFacade {
	public User findUserByEmail(String email);
	
	public abstract void save(User user);
	
	public abstract User update(User user);
	
	public abstract void delete(User user);
	
	public abstract User find(int entityID);

	public abstract List<User> findAll();

}