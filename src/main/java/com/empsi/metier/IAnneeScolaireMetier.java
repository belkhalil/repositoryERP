package com.empsi.metier;

import java.util.List;

import com.empsi.entities.AnneeScolaire;

public interface IAnneeScolaireMetier {

	public AnneeScolaire get(Long id);
	public List<AnneeScolaire> getAll();
	public AnneeScolaire save(AnneeScolaire ans);
	public AnneeScolaire update(AnneeScolaire ans);
	public AnneeScolaire delete(Long id);
}
