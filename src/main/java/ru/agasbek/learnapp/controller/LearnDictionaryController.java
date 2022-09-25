package ru.agasbek.learnapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.agasbek.learnapp.converter.LearnDictionaryConverter;
import ru.agasbek.learnapp.dto.LearnDictionaryDTO;
import ru.agasbek.learnapp.model.LearnDictionary;
import ru.agasbek.learnapp.service.LearnDictionaryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dict/learn")
public class LearnDictionaryController {
    private final LearnDictionaryService service;

    public LearnDictionaryController(LearnDictionaryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LearnDictionaryDTO>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(LearnDictionaryConverter::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearnDictionaryDTO> getById(@PathVariable long id) {
        Optional<LearnDictionary> card = service.getById(id);
        return card.isPresent() ? ResponseEntity.ok(LearnDictionaryConverter.toDTO(card.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LearnDictionaryDTO dto) {
        return ResponseEntity.ok(service.save(LearnDictionaryConverter.toDomain(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LearnDictionaryDTO dto) {
        return ResponseEntity.ok(service.update(LearnDictionaryConverter.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
