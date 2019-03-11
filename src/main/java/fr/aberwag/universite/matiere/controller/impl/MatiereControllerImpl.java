package fr.aberwag.universite.matiere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.aberwag.universite.enseignant.domain.Enseignant;
import fr.aberwag.universite.enseignant.service.impl.EnseignantServiceImpl;
import fr.aberwag.universite.matiere.controller.IMatiereController;
import fr.aberwag.universite.matiere.domain.Matiere;
import fr.aberwag.universite.matiere.service.impl.MatiereServiceImpl;

@Controller
public class MatiereControllerImpl implements IMatiereController {
	
	@Autowired
	MatiereServiceImpl matiereService;
	
	@Autowired
	EnseignantServiceImpl enseignantService;
	
	@Override
	@GetMapping("/matieres")
	public String findAll(Model model) {
		List<Matiere> liste = matiereService.findAll();
		model.addAttribute("matieres", liste);
		return "matiere/matieres";
	}

	@Override
	@GetMapping("/matiere-infos")
	public String findOne(Model model, @RequestParam("id") Integer id) {
		Matiere m = matiereService.findOne(id);
		model.addAttribute("matiere", m);
		
		return "matiere/matiere-infos";
	}

	@Override
	@GetMapping("/ajouter-matiere")
	public String ajouterMatiereFormulaire(Model model) {
		Matiere m = new Matiere();
		model.addAttribute("matiere", m);
		List<Enseignant> liste = enseignantService.findAll();
		model.addAttribute("listeEnseignants", liste);
		return "matiere/ajouter-matiere-formulaire";
	}

	@Override
	@PostMapping("/valider-matiere")
	public String validerMatiere(Model model, @ModelAttribute("matiere") Matiere matiere) {
		Matiere m = matiereService.save(matiere);
		if(m == null) {
			return "redirect:/ajouter-matiere";
		}else {
			return "redirect:/matieres";
		}
	}

	@Override
	@GetMapping("/modifier-matiere")
	public String modifierMatiereFormulaire(Model model,@RequestParam("id") Integer id) {
		Matiere m = matiereService.findOne(id);
		model.addAttribute("matiere", m);
		
		List<Enseignant> liste = enseignantService.findAll();
		model.addAttribute("listeEnseignants", liste);
		return "matiere/modifier-matiere-formulaire";
	}

	@Override
	@PostMapping("valider-matiere-modif")
	public String ValiderModification(Model model, @ModelAttribute("matiere") Matiere matiere) {
		Matiere m = matiereService.update(matiere);
		if(m == null) {
			return "redirect:/modifier-matiere";
		}else {
			return "redirect:/matieres";
		}
	}

}




