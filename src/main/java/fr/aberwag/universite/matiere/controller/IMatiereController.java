package fr.aberwag.universite.matiere.controller;

import org.springframework.ui.Model;

import fr.aberwag.universite.matiere.domain.Matiere;

public interface IMatiereController {
	public String findAll(Model model);
	
	public String findOne(Model model, Integer id);
	
	public String ajouterMatiereFormulaire(Model model);
	
	public String validerMatiere(Model model, Matiere matiere);

	public String modifierMatiereFormulaire(Model model, Integer id);

	public String ValiderModification(Model model, Matiere matiere);
}
