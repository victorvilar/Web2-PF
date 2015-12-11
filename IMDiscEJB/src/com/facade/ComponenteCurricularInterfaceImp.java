package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ComponenteCurricularDAO;
import com.model.ComponenteCurricular;


@Stateless
public class ComponenteCurricularInterfaceImp implements ComponenteCurricularInterface{

	@EJB
	private ComponenteCurricularDAO componenteCurricularDAO;
	
	@Override
	public void save(ComponenteCurricular componenteCurricular) {
		isComponenteCurricularWithAllData(componenteCurricular);
		
		componenteCurricularDAO.save(componenteCurricular);
	}

	@Override
	public ComponenteCurricular update(ComponenteCurricular componenteCurricular) {
		isComponenteCurricularWithAllData(componenteCurricular);
		
		return componenteCurricularDAO.update(componenteCurricular);
	}
	
	@Override
	public void delete(ComponenteCurricular componenteCurricular) {
		componenteCurricularDAO.delete(componenteCurricular);
	}

	@Override
	public ComponenteCurricular find(int entityID) {
		return componenteCurricularDAO.find(entityID);
	}

	@Override
	public List<ComponenteCurricular> findAll() {
		return componenteCurricularDAO.findAll();
	}
	
	private void isComponenteCurricularWithAllData(ComponenteCurricular componenteCurricular){
		boolean hasError = false;
		
		if(componenteCurricular == null){
			hasError = true;
		}
		
		if (hasError){
			throw new IllegalArgumentException("The componentecurricular is missing data. Check the parameters, they should have value.");
		}
	}
}

