package ru.agasbek.learnapp.service;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import ru.agasbek.learnapp.model.LearnCard;
import ru.agasbek.learnapp.model.LearnDictionary;
import ru.agasbek.learnapp.repository.LearnDictionaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LearnDictionaryServiceImpl implements LearnDictionaryService{
    private final LearnDictionaryRepository repository;

    public LearnDictionaryServiceImpl(LearnDictionaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LearnDictionary> getAll() {
        return IterableUtils.toList(repository.findAll());
    }

    @Override
    public Optional<LearnDictionary> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public LearnDictionary save(LearnDictionary dictionary) {
        return repository.save(dictionary);
    }

    @Override
    public LearnDictionary update(LearnDictionary dictionary) {
        return repository.save(dictionary);
    }

    @Override
    public Optional<LearnDictionary> addCardById(Long id, LearnCard card) {
        Optional<LearnDictionary> dict = repository.findById(id);
        dict.map(d -> d.getCards().add(card));
        return dict;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
