package ru.agasbek.learnapp.service;

import ru.agasbek.learnapp.model.LearnDictionary;

import java.util.List;
import java.util.Optional;

public interface LearnDictionaryService {
    List<LearnDictionary> getAll();

    Optional<LearnDictionary> getById(Long id);

    LearnDictionary save(LearnDictionary dictionary);

    LearnDictionary update(LearnDictionary dictionary);

    void deleteById(Long id);
}
