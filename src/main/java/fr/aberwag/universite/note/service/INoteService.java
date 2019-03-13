package fr.aberwag.universite.note.service;

import java.util.List;

import fr.aberwag.universite.note.domain.Note;

public interface INoteService {
	public List<Note> findAll();
	
	public Note save(Note note);
}
