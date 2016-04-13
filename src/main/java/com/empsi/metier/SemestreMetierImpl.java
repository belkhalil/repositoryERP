package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.SemestreRepository;
import com.empsi.entities.Semestre;

@Service
public class SemestreMetierImpl implements ISemestreMetier {

	@Autowired
	SemestreRepository semestreRepository;

	@Override
	public Semestre getSemestre(Long id) {
		return semestreRepository.findOne(id);
	}

	@Override
	public List<Semestre> getAll() {
		List<Semestre> semestres = semestreRepository.findAll();
		return semestres;
	}

	@Override
	public Semestre saveSemestre(Semestre Se) {
		semestreRepository.save(Se);
		return Se;
	}

	@Override
	public Semestre updateSemestre(Semestre Se) {
		semestreRepository.saveAndFlush(Se);
		return Se;
	}

	@Override
	public boolean deleteSemestre(Long id) {
		semestreRepository.delete(id);
		return true;
	}

}
