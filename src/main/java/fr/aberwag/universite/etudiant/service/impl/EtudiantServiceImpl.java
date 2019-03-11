package fr.aberwag.universite.etudiant.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.universite.etudiant.domain.Etudiant;
import fr.aberwag.universite.etudiant.repository.IEtudiantRepository;
import fr.aberwag.universite.etudiant.service.IEtudiantService;
@Service
public class EtudiantServiceImpl implements
 IEtudiantService{
	@Autowired
	IEtudiantRepository etudiantRepository;
	
	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> liste = etudiantRepository.findAll();
		for (int i = 0; i < liste.size(); i++) {
			Etudiant e = liste.get(i);
			if(e.getPhoto() == null) {
				liste.get(i).setPhoto("http://www.fapics.org/offres/image_inline_src/762/72f8f2fc0c3ca1d9da0013b480c9ddf2.jpg");
			}
		}
		return liste;
	}

	@Override
	public Etudiant findOne(Integer id) {
		Etudiant e = etudiantRepository.getOne(id);
		if(e.getPhoto() == null ) {
			e.setPhoto("http://www.fapics.org/offres/image_inline_src/762/72f8f2fc0c3ca1d9da0013b480c9ddf2.jpg");
		}
		return e;
	}

}
