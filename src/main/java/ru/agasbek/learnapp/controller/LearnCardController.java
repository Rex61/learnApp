package ru.agasbek.learnapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.agasbek.learnapp.converter.LearnCardConverter;
import ru.agasbek.learnapp.dto.LearnCardDTO;
import ru.agasbek.learnapp.model.LearnCard;
import ru.agasbek.learnapp.service.LearnCardService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class LearnCardController {
    private final LearnCardService service;

    public LearnCardController(LearnCardService service) {
        this.service = service;
    }

    @GetMapping("/learn/dictionary/{id}/cards")
    public ResponseEntity<List<LearnCardDTO>> getAllByDictionaryId(@PathVariable long id) {
        return ResponseEntity.ok(service.getAllByDictionaryId(id)
                .stream()
                .map(LearnCardConverter::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/learn/card/{id}")
    public ResponseEntity<LearnCardDTO> getById(@PathVariable long id) {
        Optional<LearnCard> card = service.getById(id);
        return card.isPresent() ? ResponseEntity.ok(LearnCardConverter.toDTO(card.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/learn/dictionary/{id}/cards")
    public ResponseEntity<?> createCard(@RequestBody LearnCardDTO dto, @PathVariable long id) {
        return ResponseEntity.ok(service.save(id, LearnCardConverter.toDomain(dto)));
    }

    @PutMapping("/learn/card")
    public ResponseEntity<?> update(@RequestBody LearnCardDTO dto) {
        return ResponseEntity.ok(service.update(LearnCardConverter.toDomain(dto)));
    }

    @DeleteMapping("/learn/card/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
