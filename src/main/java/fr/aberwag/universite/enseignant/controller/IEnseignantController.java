package fr.aberwag.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.aberwag.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {
	public String findAll(Model model);
	
	public String enseignantInfos(Model model, Integer id);
	
	public String ajouterEnseignant(Model model);
	
	public String validerEnseignant(Model model, Enseignant enseignant);

	public String modifierEnseignantFormulaire(Model model, Integer id);

	public String validerModification(Model model, Enseignant ensiegnant);
}
