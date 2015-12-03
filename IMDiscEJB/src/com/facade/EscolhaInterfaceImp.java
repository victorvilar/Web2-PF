package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.EscolhaDAO;
import com.model.Escolha;

@Stateless
public class EscolhaInterfaceImp implements EscolhaInterface {

	@EJB
	private EscolhaDAO escolhaDAO;

	@Override
	public void save(Escolha escolha) {
		isEscolhaWithAllData(escolha);

		escolhaDAO.save(escolha);
	}

	@Override
	public Escolha update(Escolha escolha) {
		isEscolhaWithAllData(escolha);

		return escolhaDAO.update(escolha);
	}

	@Override
	public void delete(Escolha escolha) {
		escolhaDAO.delete(escolha);
	}

	@Override
	public Escolha find(int entityID) {
		return escolhaDAO.find(entityID);
	}

	@Override
	public List<Escolha> findAll() {
		return escolhaDAO.findAll();
	}

	private void isEscolhaWithAllData(Escolha escolha) {
		boolean hasError = false;

		if (escolha == null) {
			hasError = true;
		}

//		if (escolha.getName() == null || "".equals(escolha.getName().trim())) {
//			hasError = true;
//		}

//		if (escolha.getWeight() <= 0) {
//			hasError = true;
//		}

		if (hasError) {
			throw new IllegalArgumentException(
					"The escolha is missing data. Check the name and weight, they should have value.");
		}
	}
}
