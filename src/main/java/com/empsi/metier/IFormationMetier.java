package com.empsi.metier;

import java.util.List;

import com.empsi.entities.Formation;

public interface IFormationMetier {

	public Formation get(Long id);
	public List<Formation> getAll();
	public Formation save(Formation formation);
	public Formation update(Formation formation);
	public boolean delete(Long id);
	
}
