package com.empsi.metier;

import java.util.List;

import com.empsi.entities.Formation;
import com.empsi.entities.FormationContinu;

public interface IFormationContinueMetier {

	public FormationContinu get(Long id);
	public List<FormationContinu> getAll();
	public FormationContinu save(FormationContinu formation);
	public FormationContinu update(FormationContinu formation);
	public boolean delete(Long id);
	
}
