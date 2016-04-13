package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.MatiereRepository;
import com.empsi.dao.ModuleRepository;
import com.empsi.entities.Matiere;
import com.empsi.entities.Module;

@Service
public class MatierMetierImpl implements IMatierMetier {
  @Autowired
  MatiereRepository matiereRepository;
  
  @Autowired 
  ModuleRepository moduleRepository;
  
	@Override
	public Matiere save(Matiere m) {
		matiereRepository.save(m);
		return m;
	}

	@Override
	public Matiere get(Long id) {

          return matiereRepository.findOne(id);
	}

	@Override
	public Matiere Update(Matiere m) {
		return matiereRepository.saveAndFlush(m);
	}

	@Override
	public List<Matiere> getAll() {
		List< Matiere> matieres = matiereRepository.findAll();
		return matieres;
	}
    
	@Override
	public Boolean delete(Long id) {
		matiereRepository.delete(id);
		return true;
	}

	@Override
	public boolean addMatierToModule(Long idMatier, Long idModule) {
		Matiere matier = matiereRepository.findOne(idMatier);
		Module module = moduleRepository.findOne(idModule);
		
	return true;
		
	}

}
