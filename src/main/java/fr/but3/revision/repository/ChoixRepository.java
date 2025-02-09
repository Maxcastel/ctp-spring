package fr.but3.revision.repository;

import fr.but3.revision.models.Choix;
import fr.but3.revision.models.Question;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ChoixRepository extends CrudRepository<Choix,Integer> {
    Optional<Choix> findFirstByQuestionNot(Question question);
}
