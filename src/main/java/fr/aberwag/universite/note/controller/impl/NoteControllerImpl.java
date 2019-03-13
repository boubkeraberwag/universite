package fr.aberwag.universite.note.controller.impl;

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

import fr.aberwag.universite.etudiant.domain.Etudiant;
import fr.aberwag.universite.etudiant.service.impl.EtudiantServiceImpl;
import fr.aberwag.universite.matiere.domain.Matiere;
import fr.aberwag.universite.matiere.service.impl.MatiereServiceImpl;
import fr.aberwag.universite.note.controller.INoteController;
import fr.aberwag.universite.note.domain.Note;
import fr.aberwag.universite.note.domain.NotePK;
import fr.aberwag.universite.note.service.impl.NoteServiceImpl;

@Controller
public class NoteControllerImpl implements INoteController{
	
	Logger log = 
		LoggerFactory.getLogger(NoteControllerImpl.class);
	
	@Autowired
	NoteServiceImpl noteService;
	
	@Autowired
	EtudiantServiceImpl etudiantService;
	@Autowired
	MatiereServiceImpl matiereService;
	
	@Override
	@GetMapping("/notes")
	public String findAll(Model model) {
		List<Note> listeNotes = noteService.findAll();
		model.addAttribute("notes", listeNotes);
		return "note/notes";
	}

	@Override
	@GetMapping("/note-formulaire-add")
	public String addNote(Model model) {
		List<Etudiant> listeEtudiant = etudiantService.findAll();
		model.addAttribute("etudiants", listeEtudiant);
		
		List<Matiere> listeMatieres = matiereService.findAll();
		model.addAttribute("matieres", listeMatieres);
		
		Note note = new Note();
		model.addAttribute("note", note);
		return "note/add-note-formulaire";
	}

	@Override
	@PostMapping("/valider-note-add")
	public String validerAdd(Model model, @ModelAttribute("note") Note note) {
//		log.info("Note: {}", note.getNote() );
//		log.info("ID Etudiant : {}", note.getEtudiant().getId());
//		log.info("ID Matière : {}", note.getMatiere().getId());
//		log.info("NotePK : {}", note.getNotePK());
		
		// Construire un objet NotePK
		NotePK npk = new NotePK();
		// lui affecter l'ID de l'etudiant
		Integer idEtudiant = note.getEtudiant().getId();
		npk.setEtudiant(idEtudiant); 
		//lui affecter l'ID de la matièere
		Integer iDMatiere = note.getMatiere().getId();
		npk.setMatiere(iDMatiere); 
		
		// AFfecter une valeur à la variable notePK
		// de l'objet note
		note.setNotePK(npk);
		noteService.save(note);
		return "redirect:/notes";
	}

	@Override
	@GetMapping("/modifier-note")
	public String modifierNoteFormulaire(
			Model model, 
			@RequestParam("idMatiere") Integer idMatiere, 
			@RequestParam("idEtudiant") Integer idEtudiant) {
		
		Note n = noteService.findOne(idEtudiant, idMatiere);
		model.addAttribute("note", n);
		return "note/mdofier-note";
	}

}













