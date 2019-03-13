package fr.aberwag.universite.note.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.aberwag.universite.etudiant.domain.Etudiant;
import fr.aberwag.universite.etudiant.service.impl.EtudiantServiceImpl;
import fr.aberwag.universite.matiere.domain.Matiere;
import fr.aberwag.universite.matiere.service.impl.MatiereServiceImpl;
import fr.aberwag.universite.note.controller.INoteController;
import fr.aberwag.universite.note.domain.Note;
import fr.aberwag.universite.note.service.impl.NoteServiceImpl;

@Controller
public class NoteControllerImpl implements INoteController{
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

}







