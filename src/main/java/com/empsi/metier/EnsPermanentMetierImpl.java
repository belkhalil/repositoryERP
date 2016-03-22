package com.empsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empsi.dao.EnsPermanentRepository;
import com.empsi.entities.users.EnsPermanent;

@Service
public class EnsPermanentMetierImpl implements IEnsPernamentMetier {
	
	@Autowired
	private EnsPermanentRepository ensPermanentRepository;

	@Override
	public EnsPermanent get(Long id) {
		return ensPermanentRepository.getOne(id);
	}

	@Override
	public List<EnsPermanent> getAll() {
		List<EnsPermanent> ensPermanents =ensPermanentRepository.findAll();
		return ensPermanents;
	}

	@Override
	public EnsPermanent save(EnsPermanent ens) {
		ensPermanentRepository.save(ens);
		return ens;
	}

	@Override
	public EnsPermanent update(EnsPermanent ens) {
		ensPermanentRepository.saveAndFlush(ens);
		return ens;
	}

	@Override
	public boolean delete(Long id) {
		ensPermanentRepository.delete(id);
		return true;
	}

}
