package com.empsi.metier;

import java.util.List;

import com.empsi.entities.FormationDiplomante;

public interface IFormationDiplomanteMetier {
	public FormationDiplomante get(Long id);
	public List<FormationDiplomante> getAll();
	public FormationDiplomante save(FormationDiplomante formation);
	public FormationDiplomante update(FormationDiplomante formation);
	public boolean delete(Long id);
}
