package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.FormationRepository;
import com.empsi.entities.Formation;
@Service
public class FormationMetierImpl implements IFormationMetier{

	@Autowired
	private  FormationRepository formationRepository;
	
	@Override
	public Formation get(Long id) {
		return formationRepository.getOne(id); 
	}

	@Override
	public List<Formation> getAll() {
		List<Formation> formations = formationRepository.findAll();
		return formations;
	}

	@Override
	public Formation save(Formation formation) {
		formationRepository.save(formation);
		return formation;
	}

	@Override
	public Formation update(Formation formation) {
		formationRepository.saveAndFlush(formation);
		return formation;
	}

	@Override
	public boolean delete(Long id) {
		formationRepository.delete(id);
		return true;
	}
	
	

}
