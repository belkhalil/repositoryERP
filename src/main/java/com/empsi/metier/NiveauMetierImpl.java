package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.FormatinDiplomanteRepository;
import com.empsi.dao.NiveauRepository;
import com.empsi.dao.SemestreRepository;
import com.empsi.entities.FormationDiplomante;
import com.empsi.entities.Niveau;
import com.empsi.entities.Semestre;

@Service
public class NiveauMetierImpl implements INiveauMetier {

	@Autowired
	NiveauRepository niveauRepository;

	@Autowired
	SemestreRepository semestreRepository;

	@Autowired
	FormatinDiplomanteRepository formatinDiplomanteRepository;

	@Override
	public Niveau get(Long id) {
		return niveauRepository.findOne(id);
	}

	@Override
	public List<Niveau> getAll() {
		List<Niveau> niveaus = niveauRepository.findAll();
		return niveaus;
	}
   
	@Override
	public Niveau save(Niveau niveau) {
		niveauRepository.save(niveau);
		return niveau;
	}

	@Override
	public Niveau update(Niveau niveau) {
		niveauRepository.saveAndFlush(niveau);
		return niveau;
	}

	@Override
	public boolean delete(Long id) {
		
		niveauRepository.delete(id);
		
		return true;
	}

	@Override
	public boolean addFormationToNiveau(Long idFormation, Long idNiveau) {
		FormationDiplomante formation = formatinDiplomanteRepository.findOne(idFormation);
		Niveau niveau = niveauRepository.findOne(idNiveau);
		niveau.getFormations().add(formation);
		
		
		niveauRepository.saveAndFlush(niveau);
		formatinDiplomanteRepository.saveAndFlush(formation);
		return true;
	}

	

	@Override
	public boolean removeFormationFromNiveau(Long idFormation, Long idNiveau) {
		FormationDiplomante formation = formatinDiplomanteRepository.findOne(idFormation);
		Niveau niveau = niveauRepository.findOne(idNiveau);
		niveau.getFormations().remove(formation);
		//formation.setNiveau(niveau);
		
		niveauRepository.saveAndFlush(niveau);
		formatinDiplomanteRepository.saveAndFlush(formation);
		return true;
	}

	

}
