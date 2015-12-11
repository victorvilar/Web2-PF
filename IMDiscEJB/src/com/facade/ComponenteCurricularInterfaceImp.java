package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ComponenteCurricularDAO;
import com.model.ComponenteCurricular;


@Stateless
public class ComponenteCurricularInterfaceImp implements ComponenteCurricularInterface{

	@EJB
	private ComponenteCurricularDAO componentecurricularDAO;
	
	@Override
	public void save(ComponenteCurricular componentecurricular) {
		isComponenteCurricularWithAllData(componentecurricular);
		
		componentecurricularDAO.save(componentecurricular);
	}

	@Override
	public ComponenteCurricular update(ComponenteCurricular componentecurricular) {
		isComponenteCurricularWithAllData(componentecurricular);
		
		return componentecurricularDAO.update(componentecurricular);
	}
	
	@Override
	public void delete(ComponenteCurricular componentecurricular) {
		componentecurricularDAO.delete(componentecurricular);
	}

	@Override
	public ComponenteCurricular find(int entityID) {
		return componentecurricularDAO.find(entityID);
	}

	@Override
	public List<ComponenteCurricular> findAll() {
		return componentecurricularDAO.findAll();
	}
	
	private void isComponenteCurricularWithAllData(ComponenteCurricular componentecurricular){
		boolean hasError = false;
		
		if(componentecurricular == null){
			hasError = true;
		}
		
		if (hasError){
			throw new IllegalArgumentException("The componentecurricular is missing data. Check the parameters, they should have value.");
		}
	}
}

