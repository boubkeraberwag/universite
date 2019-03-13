package fr.aberwag.universite.note.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.aberwag.universite.note.controller.INoteController;
import fr.aberwag.universite.note.domain.Note;
import fr.aberwag.universite.note.service.impl.NoteServiceImpl;

@Controller
public class NoteControllerImpl implements INoteController{
	@Autowired
	NoteServiceImpl noteService;
	
	@Override
	@GetMapping("/notes")
	public String findAll(Model model) {
		List<Note> listeNotes = noteService.findAll();
		model.addAttribute("notes", listeNotes);
		return "note/notes";
	}

}







