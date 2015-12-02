package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.DisciplinaDAO;
import com.model.Disciplina;

@Stateless
public class DisciplinaInterfaceImp implements DisciplinaInterface {

	@EJB
	private DisciplinaDAO disciplinaDAO;
	
	@Override
	public void save(Disciplina disciplina) {
		isDisciplinaWithAllData(disciplina);
		
		disciplinaDAO.save(disciplina);
	}

	@Override
	public Disciplina update(Disciplina disciplina) {
		isDisciplinaWithAllData(disciplina);
		
		return disciplinaDAO.update(disciplina);
	}
	
	@Override
	public void delete(Disciplina disciplina) {
		disciplinaDAO.delete(disciplina);
	}

	@Override
	public Disciplina find(int entityID) {
		return disciplinaDAO.find(entityID);
	}

	@Override
	public List<Disciplina> findAll() {
		return disciplinaDAO.findAll();
	}
	
	private void isDisciplinaWithAllData(Disciplina disciplina){
		boolean hasError = false;
		
		if(disciplina == null){
			hasError = true;
		}
		
		if (disciplina.getNomeDisciplina() == null || "".equals(disciplina.getNomeDisciplina().trim())){
			hasError = true;
		}
		
		if(disciplina.getCargaHoraria() <= 0){
			hasError = true;
		}
		
		if (hasError){
			throw new IllegalArgumentException("The disciplina is missing data. Check the name and weight, they should have value.");
		}
	}
}
