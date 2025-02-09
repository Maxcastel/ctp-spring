package fr.but3.revision.repository;

import fr.but3.revision.models.Question;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question,Integer> {
    List<Question> findAll();

    Optional<Question> findByActive(Boolean active);
}
