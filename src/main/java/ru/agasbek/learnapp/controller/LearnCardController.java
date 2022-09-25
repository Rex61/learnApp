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
@RequestMapping("/api/v1/card/learn")
public class LearnCardController {
    private final LearnCardService service;

    public LearnCardController(LearnCardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LearnCardDTO>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(LearnCardConverter::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearnCardDTO> getById(@PathVariable long id) {
        Optional<LearnCard> card = service.getById(id);
        return card.isPresent() ? ResponseEntity.ok(LearnCardConverter.toDTO(card.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LearnCardDTO dto) {
        return ResponseEntity.ok(service.save(LearnCardConverter.toDomain(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LearnCardDTO dto) {
        return ResponseEntity.ok(service.update(LearnCardConverter.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
