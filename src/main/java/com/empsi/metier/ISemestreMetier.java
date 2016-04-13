package com.empsi.metier;

import java.util.List;


import com.empsi.entities.Semestre;

public interface ISemestreMetier {
	public Semestre getSemestre(Long id);
	public List<Semestre> getAll();
	public Semestre saveSemestre(Semestre Se);
	public Semestre updateSemestre(Semestre Se);
	public boolean deleteSemestre(Long id);
	

}
