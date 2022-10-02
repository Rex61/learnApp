package ru.agasbek.learnapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.agasbek.learnapp.model.LanguageCard;
import ru.agasbek.learnapp.model.LearnCard;

import java.util.List;

public interface LanguageCardRepository extends CrudRepository<LanguageCard, Long> {
    List<LanguageCard> findByDictionaryId(long dictId);
}
