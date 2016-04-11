package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.FormatinDiplomanteRepository;
import com.empsi.dao.TypeFormationRepository;
import com.empsi.entities.FormationDiplomante;
import com.empsi.entities.TypeFormaton;

@Service
public class FormationDiplomanteImpl implements IFormationDiplomanteMetier {

	@Autowired
	FormatinDiplomanteRepository formatinDiplomanteRepository;
	@Autowired
	TypeFormationRepository typeFormationRepository;
	
	@Override
	public FormationDiplomante get(Long id) {
	return	formatinDiplomanteRepository.findOne(id);
	}

	@Override
	public List<FormationDiplomante> getAll() {
		List<FormationDiplomante> formationDiplomantes=formatinDiplomanteRepository.findAll();
		return formationDiplomantes;
	}

	@Override
	public FormationDiplomante save(FormationDiplomante formation) {
		return formatinDiplomanteRepository.save(formation);
	}

	@Override
	public FormationDiplomante update(FormationDiplomante formation) {
		return formatinDiplomanteRepository.saveAndFlush(formation);
	}

	@Override
	public boolean delete(Long id) {
		formatinDiplomanteRepository.delete(id);
		return true;
	}

	@Override
	public boolean addTypeToFormation(Long idT, Long idF) {
		TypeFormaton typef= typeFormationRepository.findOne(idT);
		FormationDiplomante formation = formatinDiplomanteRepository.findOne(idF);
        
		
		formation.getTypeFormations().add(typef);
		typef.setFormation(formation);
		formatinDiplomanteRepository.saveAndFlush(formation);
		typeFormationRepository.saveAndFlush(typef);
		return true;
	}

}
