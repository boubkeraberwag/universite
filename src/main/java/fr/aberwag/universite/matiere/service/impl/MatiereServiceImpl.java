package fr.aberwag.universite.matiere.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.universite.matiere.domain.Matiere;
import fr.aberwag.universite.matiere.repository.IMatiereRepository;
import fr.aberwag.universite.matiere.service.IMatiereService;

@Service
public class MatiereServiceImpl implements IMatiereService {

	@Autowired
	IMatiereRepository matiereRepository;
	
	@Override
	public List<Matiere> findAll() {
	List<Matiere> liste = matiereRepository.findAll();
		return liste;
	}

	@Override
	public Matiere findOne(Integer id) {
		Matiere m = matiereRepository.getOne(id);
		return m;
	}

	@Override
	public Matiere save(Matiere matiere) {
		Matiere m = matiereRepository.save(matiere);
		return m;
	}

	@Override
	public Matiere update(Matiere matiere) {
		Matiere m = matiereRepository.save(matiere);
		return m;
	}

}
