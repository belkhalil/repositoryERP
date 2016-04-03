package com.empsi.metier;

import java.util.List;


import com.empsi.entities.TypeFormaton;

public interface ITypeFormationMetier {

	public TypeFormaton get(Long id);
	public List<TypeFormaton> getAll();
	public TypeFormaton save(TypeFormaton t);
	public TypeFormaton update(TypeFormaton t);
	public boolean delete(Long id);
}
