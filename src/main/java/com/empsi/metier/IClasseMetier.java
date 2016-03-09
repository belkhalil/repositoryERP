package com.empsi.metier;

import java.util.List;

import com.empsi.entities.Classe;

public interface IClasseMetier {
	public Classe getClasse(Long id);
	public List<Classe> getAll();
	public Classe saveClasse(Classe cl);
	public Classe updateClasse(Classe cl);
	public Classe deleteClasse(Long id);
	
}
