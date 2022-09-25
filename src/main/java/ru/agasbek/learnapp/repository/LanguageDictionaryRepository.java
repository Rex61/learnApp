package ru.agasbek.learnapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.agasbek.learnapp.model.LanguageDictionary;

public interface LanguageDictionaryRepository extends CrudRepository<LanguageDictionary, Long> {
}
