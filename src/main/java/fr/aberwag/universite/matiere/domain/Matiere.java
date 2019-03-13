package fr.aberwag.universite.matiere.domain;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.aberwag.universite.enseignant.domain.Enseignant;
import fr.aberwag.universite.note.domain.Note;

@Entity
@Table(name="T_MATIERE")
public class Matiere {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id ;

	@Column(name="NUMERO_MATIERE")
	private Integer numero;

	@Column(name="NOM")
	private String nom;

	@Column(name="COEF")
	private Integer coef;

	@ManyToOne
	@JoinColumn(name="ID_ENSEIGNANT")
	private Enseignant enseignant;
	
	@OneToMany(mappedBy="matiere")
	private List<Note> notes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCoef() {
		return coef;
	}

	public void setCoef(Integer coef) {
		this.coef = coef;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
