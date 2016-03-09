package com.empsi.metier;

import java.util.List;

import com.empsi.dao.AbsenceEtudiantRepository;
import com.empsi.entities.AbsenceEtudiant;

public class AbsenceEtudiantMetierImpl implements IAbsenceEtudiantMetier {

	private AbsenceEtudiantRepository absence;
	@Override
	public AbsenceEtudiant get(Long id) {
		// TODO Auto-generated method stub
		return  absence.getOne(id);
	}

	@Override
	public List<AbsenceEtudiant> getAll() {
		// TODO Auto-generated method stub
		return absence.findAll();
	}

	@Override
	public AbsenceEtudiant save(AbsenceEtudiant abs) {
		// TODO Auto-generated method stub
		return absence.save(abs);
	}

	@Override
	public AbsenceEtudiant update(AbsenceEtudiant abs) {
		// TODO Auto-generated method stub
		return absence.saveAndFlush(abs);
	}

	@Override
	public boolean delete(Long id) {
		if( absence.getOne(id) != null)
			absence.delete(id);
		else
			return false;
		return true;
	}

}
