package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.TypeFormationRepository;
import com.empsi.entities.TypeFormaton;

@Service
public class TypeFormationMetierImpl implements ITypeFormationMetier {
	
	@Autowired
	TypeFormationRepository typeFormationRepository;

	@Override
	public TypeFormaton get(Long id) {
		return typeFormationRepository.findOne(id);
	}

	@Override
	public List<TypeFormaton> getAll() {
		List<TypeFormaton> typeFormatons=typeFormationRepository.findAll();
		return typeFormatons;
	}

	@Override
	public TypeFormaton save(TypeFormaton t) {
		typeFormationRepository.save(t);
		return t;
	}

	@Override
	public TypeFormaton update(TypeFormaton t) {
		typeFormationRepository.saveAndFlush(t);
		return t;
	}

	@Override
	public boolean delete(Long id) {
		typeFormationRepository.delete(id);
		return true;
	}

}
