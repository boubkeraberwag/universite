package fr.aberwag.universite.enseignant.service;

import java.util.List;

import fr.aberwag.universite.enseignant.domain.Enseignant;

public interface IEnseignantService {
	public List<Enseignant> findAll();
	
	public Enseignant getOne(Integer id);
	
	public Enseignant ajouterEnseignant(Enseignant enseignant);
	
	public Enseignant modifierEnseignant(Enseignant enseignant);
}
