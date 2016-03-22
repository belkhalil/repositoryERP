package com.empsi.metier;

import java.util.List;

import com.empsi.entities.users.Compte;


public interface ICompteMetier {
	public Compte save(Compte c);
	public Compte get(Long id);
	public Compte Update(Compte c );
	public List<Compte> getAll();
	public Boolean delete(Long id);
	
}
