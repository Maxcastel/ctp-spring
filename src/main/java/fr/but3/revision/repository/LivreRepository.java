package fr.but3.revision.repository;

import fr.but3.revision.models.Livre;
import org.springframework.data.repository.CrudRepository;

public interface LivreRepository extends CrudRepository<Livre,Integer> {
}
