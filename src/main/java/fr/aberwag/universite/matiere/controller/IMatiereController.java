package fr.aberwag.universite.matiere.controller;

import org.springframework.ui.Model;

public interface IMatiereController {
	public String findAll(Model model);
	public String findOne(Model model, Integer id);
}
