package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.CursoDAO;
import com.model.Curso;

@Stateless
public class CursoInterfaceImp implements CursoInterface {

	@EJB
	private CursoDAO cursoDAO;
	
	@Override
	public void save(Curso curso) {
		isCursoWithAllData(curso);
		
		cursoDAO.save(curso);
	}

	@Override
	public Curso update(Curso curso) {
		isCursoWithAllData(curso);
		
		return cursoDAO.update(curso);
	}
	
	@Override
	public void delete(Curso curso) {
		cursoDAO.delete(curso);
	}

	@Override
	public Curso find(int entityID) {
		return cursoDAO.find(entityID);
	}

	@Override
	public List<Curso> findAll() {
		return cursoDAO.findAll();
	}
	
	private void isCursoWithAllData(Curso curso){
		boolean hasError = false;
		
		if(curso == null){
			hasError = true;
		}
		
		if (curso.getNomeCurso() == null || "".equals(curso.getNomeCurso().trim())){
			hasError = true;
		}
		
		if(curso.getCargaHoraria() <= 0){
			hasError = true;
		}
		
		if (hasError){
			throw new IllegalArgumentException("The curso is missing data. Check the name and weight, they should have value.");
		}
	}
}
