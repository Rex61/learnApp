package ru.agasbek.learnapp.service;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import ru.agasbek.learnapp.model.LanguageCard;
import ru.agasbek.learnapp.repository.LanguageCardRepository;
import ru.agasbek.learnapp.repository.LanguageDictionaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageCardServiceImpl implements LanguageCardService{
    private final LanguageCardRepository repository;
    private final LanguageDictionaryRepository dictionaryRepository;

    public LanguageCardServiceImpl(LanguageCardRepository repository, LanguageDictionaryRepository dictionaryRepository) {
        this.repository = repository;
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public List<LanguageCard> getAllByDictionaryId(long dictId) {
        return IterableUtils.toList(repository.findAll());
    }

    @Override
    public Optional<LanguageCard> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public LanguageCard save(long dictId, LanguageCard card) {
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
