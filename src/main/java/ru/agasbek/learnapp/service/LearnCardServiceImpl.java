package ru.agasbek.learnapp.service;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import ru.agasbek.learnapp.model.LearnCard;
import ru.agasbek.learnapp.repository.LearnCardRepository;
import ru.agasbek.learnapp.repository.LearnDictionaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LearnCardServiceImpl implements LearnCardService {
    private final LearnCardRepository repository;
    private final LearnDictionaryRepository dictionaryRepository;

    public LearnCardServiceImpl(LearnCardRepository repository, LearnDictionaryRepository dictionaryRepository) {
        this.repository = repository;
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public List<LearnCard> getAllByDictionaryId(long id) {
        return repository.findByDictionaryId(id);
    }

    @Override
    public Optional<LearnCard> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public LearnCard save(long dictId, LearnCard card) {
        return dictionaryRepository.findById(dictId).map(dict -> {
            card.setDictionary(dict);
            return repository.save(card);
        }).orElseThrow();
    }

    @Override
    public LearnCard update(LearnCard card) {
        LearnCard old = repository.findById(card.getId())
                .orElseThrow(() -> new IllegalArgumentException("Leard card with this id doesnt exist ID=" + card.getId()));
        old.setDescription(card.getDescription());
        old.setWord(card.getWord());
        return repository.save(old);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
