package ru.agasbek.learnapp.service;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import ru.agasbek.learnapp.model.LearnCard;
import ru.agasbek.learnapp.repository.LearnCardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LearnCardServiceImpl implements LearnCardService {
    private final LearnCardRepository repository;

    public LearnCardServiceImpl(LearnCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LearnCard> getAll() {
        return IterableUtils.toList(repository.findAll());
    }

    @Override
    public Optional<LearnCard> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public LearnCard save(LearnCard card) {
        return repository.save(card);
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
