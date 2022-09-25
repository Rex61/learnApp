package ru.agasbek.learnapp.service;

import ru.agasbek.learnapp.model.LanguageCard;

import java.util.List;
import java.util.Optional;

public interface LanguageCardService {
    List<LanguageCard> getAll();

    Optional<LanguageCard> getById(Long id);

    LanguageCard save(LanguageCard card);

    LanguageCard update(LanguageCard card);

    void deleteById(Long id);
}
