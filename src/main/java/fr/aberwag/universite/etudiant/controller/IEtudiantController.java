package fr.aberwag.universite.etudiant.controller;

import org.springframework.ui.Model;

public interface IEtudiantController {
	public String findAll(Model model);
	
	public String findOneEtudiant(Model model, Integer id);
}
