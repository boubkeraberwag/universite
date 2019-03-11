package fr.aberwag.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.aberwag.universite.enseignant.controller.IEnseignantController;
import fr.aberwag.universite.enseignant.domain.Enseignant;
import fr.aberwag.universite.enseignant.service.impl.EnseignantServiceImpl;

@Controller
public class EnseignantController implements IEnseignantController {

	Logger log = LoggerFactory.getLogger(EnseignantController.class);
	@Autowired
	EnseignantServiceImpl enseignantService;

	@Override
	@GetMapping("/enseignants")
	public String findAll(Model model) {
		List<Enseignant> liste = enseignantService.findAll();
		log.info("Nombre enseignants: {}", liste.size());
		model.addAttribute("enseignants", liste);
		return "enseignant/enseignants";
	}

	@Override
	@GetMapping("/enseignant-infos")
	public String enseignantInfos(Model model, @RequestParam("id") Integer id) {
		Enseignant enseignant = enseignantService.getOne(id);
		model.addAttribute("enseignant",enseignant);
		return "enseignant/enseignant-infos";
	}

	@Override
	@GetMapping("/ajouter-enseignant")
	public String ajouterEnseignant(Model model) {
		Enseignant enseignant = new Enseignant();
		model.addAttribute("enseignant" , enseignant);
		return "enseignant/ajouter-enseignant-formulaire";
	}

	@Override
	@PostMapping("/valider-enseignant")
	public String validerEnseignant(Model model, @ModelAttribute Enseignant enseignant) {
		log.info("Nom enseignant : {}" , enseignant.getNom());
		System.out.println("Nom enseignant : " + enseignant.getNom() );
		log.info("Prenom enseignant : {}" , enseignant.getPrenom());
		log.info("Numero enseignant : {}" , enseignant.getNumero());
		log.info("date Naissace enseignant : {}" , enseignant.getDateNaissance());
		log.info("date embauche enseignant : {}" , enseignant.getDateEmbauche());
		log.info("Grade enseignant : {}" , enseignant.getGrade());
		log.info("Sexe enseignant : {}" , enseignant.getSexe());
		log.info("Photo enseignant : {}" , enseignant.getPhoto());
		// appel du service pour sauvegarder l'enseignant dans la bdd
		Enseignant en = enseignantService.ajouterEnseignant(enseignant);
		
		if(en == null) {
			return "redirect:/ajouter-enseignant";
		}else {
			return "redirect:/enseignants";
		}
		
	}

	@Override
	@GetMapping("/modifier-enseignant")
	public String modifierEnseignantFormulaire(Model model, @RequestParam("id") Integer id) {
		Enseignant enseignant = enseignantService.getOne(id);
		model.addAttribute("enseignant", enseignant);
		return "enseignant/modifier-enseignant-formulaire";
	}

	@Override
	@PostMapping("valider-modification-enseignant")
	public String validerModification(Model model, @ModelAttribute("enseignant") Enseignant ensiegnant) {
		Enseignant en = enseignantService.modifierEnseignant(ensiegnant);
		
		if(en == null) {
			return "redirect:/modifier-enseignant";
		}else {
			return "redirect:/enseignants";
		}
	}
	
	
}
