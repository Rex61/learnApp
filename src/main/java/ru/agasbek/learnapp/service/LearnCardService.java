package ru.agasbek.learnapp.service;

import ru.agasbek.learnapp.model.LearnCard;

import java.util.List;
import java.util.Optional;

public interface LearnCardService {
    List<LearnCard> getAll();

    Optional<LearnCard> getById(Long id);

    LearnCard save(LearnCard card);

    LearnCard update(LearnCard card);

    void deleteById(Long id);
}
