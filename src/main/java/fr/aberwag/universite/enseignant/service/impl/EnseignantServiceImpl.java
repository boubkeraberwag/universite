package fr.aberwag.universite.enseignant.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.universite.enseignant.domain.Enseignant;
import fr.aberwag.universite.enseignant.repository.IEnseignantRepository;
import fr.aberwag.universite.enseignant.service.IEnseignantService;

@Service
public class EnseignantServiceImpl implements IEnseignantService {
	Logger log = LoggerFactory.getLogger(EnseignantServiceImpl.class);
	@Autowired
	IEnseignantRepository enseignantRepository;

	@Override
	public List<Enseignant> findAll() {
		List<Enseignant> liste = enseignantRepository.findAll();
		// vérifier l'image pour chaque enseignant
		// SI l'enseignant ne possède pas d'image on lui donne une image par default
		// http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg
		
		for(int i = 0 ; i < liste.size(); i++) {
			Enseignant e = liste.get(i);
			log.info("Image de l'enseignant : {}", e.getPhoto() );
			if(e.getPhoto() == null || e.getPhoto().equals("")) {
				liste.get(i).setPhoto("http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg");
			}
		}
		
		return liste;
	}

	@Override
	public Enseignant getOne(Integer id) {
		Enseignant e = enseignantRepository.getOne(id);
		if(e.getPhoto() == null || e.getPhoto().equals("")) {
			e.setPhoto("http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg");
		}
		return e;
	}

	@Override
	public Enseignant ajouterEnseignant(Enseignant enseignant) {
		Enseignant e = enseignantRepository.save(enseignant);
		return e;
	}

	@Override
	public Enseignant modifierEnseignant(Enseignant enseignant) {
		Enseignant e = enseignantRepository.save(enseignant);
		return e;
	}
	
	
	
	
	
	
	
}
