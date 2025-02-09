package fr.but3.revision.repository;

import fr.but3.revision.models.Auteur;
import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur,Integer> {
}
