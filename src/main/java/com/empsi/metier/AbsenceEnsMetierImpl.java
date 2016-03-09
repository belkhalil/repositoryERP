package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.empsi.dao.AbsenceEnsRepository;
import com.empsi.entities.AbsenceEns;

public class AbsenceEnsMetierImpl implements IAbsenceEnsMetier {

	@Autowired
	private AbsenceEnsRepository absence;
	
	@Override
	public AbsenceEns get(Long id) {
		
		return absence.getOne(id);
	}

	@Override
	public List<AbsenceEns> getAll() {
		// TODO Auto-generated method stub
		return absence.findAll();
	}

	@Override
	public AbsenceEns save(AbsenceEns abs) {
		// TODO Auto-generated method stub
		return absence.save(abs);
	}

	@Override
	public AbsenceEns update(AbsenceEns abs) {
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
