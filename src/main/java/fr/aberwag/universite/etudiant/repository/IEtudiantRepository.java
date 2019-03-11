package fr.aberwag.universite.etudiant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.aberwag.universite.etudiant.domain.Etudiant;
@Repository
public interface IEtudiantRepository
extends JpaRepository<Etudiant, Integer>

{

}
