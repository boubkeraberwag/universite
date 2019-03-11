package fr.aberwag.universite.matiere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.aberwag.universite.matiere.controller.IMatiereController;
import fr.aberwag.universite.matiere.domain.Matiere;
import fr.aberwag.universite.matiere.service.impl.MatiereServiceImpl;

@Controller
public class MatiereControllerImpl implements IMatiereController {
	
	@Autowired
	MatiereServiceImpl matiereService;
	
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

}




