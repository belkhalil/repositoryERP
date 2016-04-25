package com.empsi.metier;

import java.util.List;

import com.empsi.entities.Matiere;


public interface IMatierMetier {
	public Matiere save(Matiere m);
	public Matiere get(Long id);
	public Matiere Update(Matiere m );
	public List<Matiere> getAll();
	public Boolean delete(Long id);
	
}
