package ru.agasbek.learnapp.service;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import ru.agasbek.learnapp.model.LanguageCard;
import ru.agasbek.learnapp.repository.LanguageCardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageCardServiceImpl implements LanguageCardService{
    private final LanguageCardRepository repository;

    public LanguageCardServiceImpl(LanguageCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LanguageCard> getAll() {
        return IterableUtils.toList(repository.findAll());
    }

    @Override
    public Optional<LanguageCard> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public LanguageCard save(LanguageCard card) {
        return repository.save(card);
    }

    @Override
    public LanguageCard update(LanguageCard card) {
        LanguageCard old = repository.findById(card.getId())
                .orElseThrow(() -> new IllegalArgumentException("Language card with this id doesnt exist ID=" + card.getId()));
        old.setTranslation(card.getTranslation());
        old.setWord(card.getWord());
        return repository.save(old);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
