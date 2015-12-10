package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.facade.CursoInterfaceImp;
import com.facade.EstruturaCurricularInterface;
import com.facade.EstruturaCurricularInterfaceImp;
import com.model.Curso;
import com.model.EstruturaCurricular;

@ManagedBean(name = "EstruturaCurricularMB")
@SessionScoped
public class EstruturaCurricularMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187732078408137806L;

	private Curso curso;
	private CursoInterfaceImp cursoInterfaceImp;
	
	private EstruturaCurricular estruturaCurricular;
	
	@EJB
	private EstruturaCurricularInterface estruturaCurricularInterface;

	private static final String CREATE_ESTRUTURA_CURRICULAR = "createEstruturaCurricular";
	private static final String DELETE_ESTRUTURA_CURRICULAR = "deleteEstruturaCurricular";
	private static final String UPDATE_ESTRUTURA_CURRICULAR = "updateEstruturaCurricular";
	private static final String LIST_ALL_ESTRUTURA_CURRICULARES = "listAllEstruturasCurriculares";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	public EstruturaCurricularMB(){
		curso = new Curso();
		cursoInterfaceImp = new CursoInterfaceImp();
	}
	
	public EstruturaCurricular getEstruturaCurricular() {

		if (estruturaCurricular == null) {
			estruturaCurricular = new EstruturaCurricular();
		}
		return estruturaCurricular;
	}

	public void setEstruturaCurricular(EstruturaCurricular estruturaCurricular) {
		this.estruturaCurricular = estruturaCurricular;
	}

	public List<EstruturaCurricular> getAllEstruturaCurriculars() {
		return estruturaCurricularInterface.findAll();
	}

	public String updateEstruturaCurricularStart() {
		return UPDATE_ESTRUTURA_CURRICULAR;
	}

	public String updateEstruturaCurricularEnd() {
		try {
			estruturaCurricularInterface.update(estruturaCurricular);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}

		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_ESTRUTURA_CURRICULARES;
	}

	public String deleteEstruturaCurricularStart() {
		return DELETE_ESTRUTURA_CURRICULAR;
	}

	public String deleteEstruturaCurricularEnd() {
		try {
			estruturaCurricularInterface.delete(estruturaCurricular);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}

		sendInfoMessageToUser("Operation Complete: Delete");

		return LIST_ALL_ESTRUTURA_CURRICULARES;
	}

	public String createEstruturaCurricularStart() {
		return CREATE_ESTRUTURA_CURRICULAR;
	}

	public String createEstruturaCurricularEnd() {
		try {
			System.out.println("------------- id curso: " + curso.getIdCurso());
			curso = cursoInterfaceImp.find(curso.getIdCurso());
			estruturaCurricular.setCurso(curso);
			
			System.out.println("Nome da estrutura: " + estruturaCurricular.getNomeEstrutura());
			
			//estruturaCurricularInterface.save(estruturaCurricular);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm");

			return STAY_IN_THE_SAME_PAGE;
		}

		sendInfoMessageToUser("Operation Complete: Create");

		return LIST_ALL_ESTRUTURA_CURRICULARES;
	}

	public String listAllEstruturaCurriculares() {
		return LIST_ALL_ESTRUTURA_CURRICULARES;
	}

	private void sendInfoMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

	private void sendErrorMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}

	
	public EstruturaCurricular getEstruturacurricular() {
		return estruturaCurricular;
	}

	
	public void setEstruturacurricular(EstruturaCurricular estruturaCurricular) {
		this.estruturaCurricular = estruturaCurricular;
	}

	
	public Curso getCurso() {
		return curso;
	}

	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
