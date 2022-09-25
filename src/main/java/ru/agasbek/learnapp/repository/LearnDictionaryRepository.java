package ru.agasbek.learnapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.agasbek.learnapp.model.LearnDictionary;

public interface LearnDictionaryRepository extends CrudRepository<LearnDictionary, Long> {
}
