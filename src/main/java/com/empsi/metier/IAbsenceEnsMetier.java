package com.empsi.metier;

import java.util.List;

import com.empsi.entities.AbsenceEns;

public interface IAbsenceEnsMetier {

	public AbsenceEns get(Long id);
	public List<AbsenceEns> getAll();
	public AbsenceEns save(AbsenceEns abs);
	public AbsenceEns update(AbsenceEns abs);
	public boolean delete(Long id);

}
