package com.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.facade.ComponenteCurricularInterface;
import com.facade.DisciplinaInterface;
import com.facade.EstruturaCurricularInterface;
import com.model.ComponenteCurricular;
import com.model.Disciplina;
import com.model.EstruturaCurricular;

@ManagedBean
@RequestScoped
public class ComponenteCurricularMB {

	private int indexDisc = -1;
	private int indexEst = -1;

	@EJB
	private ComponenteCurricularInterface componenteCurricularInterface;
	private ComponenteCurricular componenteCurricular;

	@EJB
	private DisciplinaInterface disciplinaInterface;
	private Disciplina disciplina;

	@EJB
	private EstruturaCurricularInterface estruturaCurricularInterface;
	private EstruturaCurricular estruturaCurricular;
	
	private static final String CREATE_COMPONENTE_CURRICULAR = "createComponenteCurricular";
	private static final String DELETE_COMPONENTE_CURRICULAR = "deleteComponenteCurricular";
	private static final String UPDATE_COMPONENTE_CURRICULAR = "updateComponenteCurricular";
	private static final String LIST_ALL_COMPONENTES_CURRICULARES = "listAllComponentesCurriculares";
	private static final String LIST_COMPONENTE_CURRICULAR_ESTRUTURA = "listAllComponenteCurricularEstrutura";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	public ComponenteCurricular getComponenteCurricular() {
		if (componenteCurricular == null) {
			componenteCurricular = new ComponenteCurricular();
		}
		return componenteCurricular;
	}

	public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
		this.componenteCurricular = componenteCurricular;
	}

	public List<ComponenteCurricular> getAllComponenteCurriculares() {
		return componenteCurricularInterface.findAll();
	}

	public List<ComponenteCurricular> getAllComponenteCurricularesByEstrutura(int id) {
		return componenteCurricularInterface.findByIdEstrutura(id);
	}

	public String updateComponenteCurricularStart() {
		return UPDATE_COMPONENTE_CURRICULAR;
	}

	public String updateComponenteCurricularEnd() {
		try {

			/*ComponenteCurricular ec = new ComponenteCurricular();
			ec = componenteCurricularInterface.find(componenteCurricular.getIdComponenteCurricular());
			curso = ec.getCurso();
			componenteCurricular.setCurso(curso);

			componenteCurricularInterface.update(componenteCurricular);*/

		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm1");
			return STAY_IN_THE_SAME_PAGE;
		}

		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_COMPONENTES_CURRICULARES;
	}

	public String deleteComponenteCurricularStart() {
		return DELETE_COMPONENTE_CURRICULAR;
	}

	public String deleteComponenteCurricularEnd() {
		try {
			/*componenteCurricular = componenteCurricularInterface.find(componenteCurricular.getIdComponenteCurricular());
			componenteCurricularInterface.delete(componenteCurricular);*/
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}

		sendInfoMessageToUser("Operation Complete: Delete");
		return LIST_ALL_COMPONENTES_CURRICULARES;
	}

	public String createComponenteCurricularStart() {
		return CREATE_COMPONENTE_CURRICULAR;
	}

	public String createComponenteCurricularEnd() {
		try {
			
			estruturaCurricular = estruturaCurricularInterface.find(indexEst);
			disciplina = disciplinaInterface.find(indexDisc);
			
			componenteCurricular.setDisciplina(disciplina);
			componenteCurricular.setEstruturaCurricular(estruturaCurricular);
			
			componenteCurricularInterface.save(componenteCurricular);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operation Complete: Create");
		return LIST_ALL_COMPONENTES_CURRICULARES;
	}

	public String listAllComponentesCurriculares() {
		return LIST_ALL_COMPONENTES_CURRICULARES;
	}

	public String listComponenteCurricularEstrutura() {
		return LIST_COMPONENTE_CURRICULAR_ESTRUTURA;
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

	public ComponenteCurricularInterface getComponenteCurricularInterface() {
		return componenteCurricularInterface;
	}

	public void setComponenteCurricularInterface(ComponenteCurricularInterface componenteCurricularInterface) {
		this.componenteCurricularInterface = componenteCurricularInterface;
	}

	public Disciplina getDisciplina() {
		if(disciplina == null){
			disciplina = new Disciplina();
		}
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public DisciplinaInterface getDisciplinaInterface() {
		return disciplinaInterface;
	}

	public void setDisciplinaInterface(DisciplinaInterface disciplinaInterface) {
		this.disciplinaInterface = disciplinaInterface;
	}

	public EstruturaCurricular getEstruturaCurricular() {
		
		if(estruturaCurricular == null){
			estruturaCurricular = new EstruturaCurricular();
		}
		return estruturaCurricular;
	}

	public void setEstruturaCurricular(EstruturaCurricular estruturaCurricular) {
		this.estruturaCurricular = estruturaCurricular;
	}

	public EstruturaCurricularInterface getEstruturaCurricularInterface() {
		return estruturaCurricularInterface;
	}

	public void setEstruturaCurricularInterface(EstruturaCurricularInterface estruturaCurricularInterface) {
		this.estruturaCurricularInterface = estruturaCurricularInterface;
	}

	public int getIndexDisc() {
		return indexDisc;
	}

	public void setIndexDisc(int indexDisc) {
		this.indexDisc = indexDisc;
	}

	public int getIndexEst() {
		return indexEst;
	}

	public void setIndexEst(int indexEst) {
		this.indexEst = indexEst;
	}

	
	
}
