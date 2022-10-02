package ru.agasbek.learnapp.service;

import ru.agasbek.learnapp.model.LanguageCard;

import java.util.List;
import java.util.Optional;

public interface LanguageCardService {
    List<LanguageCard> getAllByDictionaryId(long dictId);

    Optional<LanguageCard> getById(Long id);

    LanguageCard save(long dictId, LanguageCard card);

    LanguageCard update(LanguageCard card);

    void deleteById(Long id);
}
