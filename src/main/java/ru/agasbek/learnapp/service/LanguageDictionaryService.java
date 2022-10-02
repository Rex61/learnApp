package ru.agasbek.learnapp.service;

import ru.agasbek.learnapp.model.LanguageDictionary;

import java.util.List;
import java.util.Optional;

public interface LanguageDictionaryService {
    List<LanguageDictionary> getAll();

    Optional<LanguageDictionary> getById(Long id);

    LanguageDictionary save(LanguageDictionary dictionary);

    LanguageDictionary update(LanguageDictionary dictionary);

    void deleteById(Long id);
}
