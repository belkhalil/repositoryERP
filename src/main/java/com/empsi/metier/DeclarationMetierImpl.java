package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.DeclarationRepository;
import com.empsi.entities.Declaration;

@Service
public class DeclarationMetierImpl implements IDeclarationMetier {

	@Autowired
	private DeclarationRepository declarationRepository;
	
	@Override
	public Declaration get(Long id) {
		return declarationRepository.getOne(id);
	}

	@Override
	public List<Declaration> getAll() {
		List<Declaration> declarations = declarationRepository.findAll();
		return declarations;
	}

	@Override
	public Declaration save(Declaration dec) {
		return declarationRepository.save(dec);	
	}

	@Override
	public Declaration update(Declaration dec) {
		declarationRepository.saveAndFlush(dec);
		return dec;
	}

	@Override
	public boolean delete(Long id) {
		declarationRepository.delete(id);
		return true;
	}

}
