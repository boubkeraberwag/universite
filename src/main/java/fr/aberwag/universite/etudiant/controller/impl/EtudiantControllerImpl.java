package fr.aberwag.universite.etudiant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.aberwag.universite.etudiant.controller.IEtudiantController;
import fr.aberwag.universite.etudiant.domain.Etudiant;
import fr.aberwag.universite.etudiant.service.impl.EtudiantServiceImpl;
@Controller
public class EtudiantControllerImpl implements IEtudiantController{

	@Autowired
	EtudiantServiceImpl etudiantService;
	
	@Override
	@GetMapping("/etudiants")
	public String findAll(Model model) {
		List<Etudiant> listeEtudiants = etudiantService.findAll();
		model.addAttribute("etudiants", listeEtudiants);
		return "etudiant/etudiants";
	}

	@Override
	@GetMapping("/etudiant-infos")
	public String findOneEtudiant(Model model, Integer id) {
		Etudiant e  = etudiantService.findOne(id);
		model.addAttribute("etudiant", e);
		return "etudiant/etudiant-infos";
	}
	
}
