package ru.agasbek.learnapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.agasbek.learnapp.model.LanguageCard;

public interface LanguageCardRepository extends CrudRepository<LanguageCard, Long> {
}
