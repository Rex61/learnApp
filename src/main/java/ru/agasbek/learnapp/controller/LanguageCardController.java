package ru.agasbek.learnapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.agasbek.learnapp.converter.LanguageCardConverter;
import ru.agasbek.learnapp.dto.LanguageCardDTO;
import ru.agasbek.learnapp.model.LanguageCard;
import ru.agasbek.learnapp.service.LanguageCardService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/card/language")
public class LanguageCardController {
    private final LanguageCardService service;

    public LanguageCardController(LanguageCardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LanguageCardDTO>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(LanguageCardConverter::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageCardDTO> getById(@PathVariable long id) {
        Optional<LanguageCard> card = service.getById(id);
        return card.isPresent() ? ResponseEntity.ok(LanguageCardConverter.toDTO(card.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LanguageCardDTO dto) {
        return ResponseEntity.ok(service.save(LanguageCardConverter.toDomain(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LanguageCardDTO dto) {
        return ResponseEntity.ok(service.update(LanguageCardConverter.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
