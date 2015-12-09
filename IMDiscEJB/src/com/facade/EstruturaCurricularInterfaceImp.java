package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.EstruturaCurricularDAO;
import com.model.EstruturaCurricular;

@Stateless
public class EstruturaCurricularInterfaceImp implements EstruturaCurricularInterface {

	@EJB
	private EstruturaCurricularDAO estruturacurricularDAO;
	
	@Override
	public void save(EstruturaCurricular estruturacurricular) {
		isEstruturaCurricularWithAllData(estruturacurricular);
		
		estruturacurricularDAO.save(estruturacurricular);
	}

	@Override
	public EstruturaCurricular update(EstruturaCurricular estruturacurricular) {
		isEstruturaCurricularWithAllData(estruturacurricular);
		
		return estruturacurricularDAO.update(estruturacurricular);
	}
	
	@Override
	public void delete(EstruturaCurricular estruturacurricular) {
		estruturacurricularDAO.delete(estruturacurricular);
	}

	@Override
	public EstruturaCurricular find(int entityID) {
		return estruturacurricularDAO.find(entityID);
	}

	@Override
	public List<EstruturaCurricular> findAll() {
		return estruturacurricularDAO.findAll();
	}
	
	private void isEstruturaCurricularWithAllData(EstruturaCurricular estruturacurricular){
		boolean hasError = false;
		
		if(estruturacurricular == null){
			hasError = true;
		}
		
		if (estruturacurricular.getNomeEstrutura() == null || "".equals(estruturacurricular.getNomeEstrutura().trim())){
			hasError = true;
		}
		
		if(estruturacurricular.getCurso().getIdCurso() <= 0){
			hasError = true;
		}
		
		if (hasError){
			throw new IllegalArgumentException("The estruturacurricular is missing data. Check the parameters, they should have value.");
		}
	}
}
