package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.CompteRepository;
import com.empsi.entities.Compte;

@Service
public class CompteMetierImpl implements ICompteMetier{
	
	@Autowired
	private CompteRepository  compteRepository;

	@Override
	public Compte save(Compte c) {
		compteRepository.save(c);
		return c;
	}

	@Override
	public Compte get(Long id) {
		Compte c =compteRepository.getOne(id);
		return c;
	}

	@Override
	public List<Compte> getAll() {
		List<Compte> comptes= compteRepository.findAll();
		return  comptes;
	}

	@Override
	public Boolean delete(Long id) {
		if(compteRepository.getOne(id)!= null)
		compteRepository.delete(id);
		return true;
		
	}

	@Override
	public Compte Update(Compte c) {
		compteRepository.saveAndFlush(c);
		return c; 
	}

	

	


	
	
	
	
      
	

}
