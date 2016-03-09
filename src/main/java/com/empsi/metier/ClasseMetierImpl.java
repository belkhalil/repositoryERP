package com.empsi.metier;

import java.util.List;

import com.empsi.dao.ClasseRepository;
import com.empsi.entities.Classe;

public class ClasseMetierImpl implements IClasseMetier{

	private ClasseRepository classeRepository;
	@Override
	public Classe getClasse(Long id) {
		
		return classeRepository.findOne(id);
	}

	@Override
	public List<Classe> getAll() {
		
		return classeRepository.findAll();
	}

	@Override
	public Classe saveClasse(Classe cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe updateClasse(Classe cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe deleteClasse(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
