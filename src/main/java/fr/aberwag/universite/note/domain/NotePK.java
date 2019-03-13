package fr.aberwag.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotePK  implements Serializable{

	@Column(name="ID_ETUDIANT")
	private Integer etudiant;
	
	@Column(name="ID_MATIERE")
	private Integer matiere;

	public Integer getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Integer etudiant) {
		this.etudiant = etudiant;
	}

	public Integer getMatiere() {
		return matiere;
	}

	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}
	
	
}
