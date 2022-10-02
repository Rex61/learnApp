package ru.agasbek.learnapp.service;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import ru.agasbek.learnapp.model.LanguageDictionary;
import ru.agasbek.learnapp.repository.LanguageDictionaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageDictionaryServiceImpl implements LanguageDictionaryService{
    private final LanguageDictionaryRepository repository;

    public LanguageDictionaryServiceImpl(LanguageDictionaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LanguageDictionary> getAll() {
        return IterableUtils.toList(repository.findAll());
    }

    @Override
    public Optional<LanguageDictionary> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public LanguageDictionary save(LanguageDictionary dictionary) {
        return repository.save(dictionary);
    }

    @Override
    public LanguageDictionary update(LanguageDictionary dictionary) {
        return repository.save(dictionary);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
