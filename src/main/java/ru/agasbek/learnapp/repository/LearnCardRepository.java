package ru.agasbek.learnapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.agasbek.learnapp.model.LearnCard;

import java.util.List;

public interface LearnCardRepository extends CrudRepository<LearnCard, Long> {
    List<LearnCard> findByDictionaryId(long dictId);
}
