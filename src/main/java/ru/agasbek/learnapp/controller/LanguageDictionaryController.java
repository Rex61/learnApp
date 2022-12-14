package ru.agasbek.learnapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.agasbek.learnapp.converter.LanguageDictionaryConverter;
import ru.agasbek.learnapp.dto.LanguageDictionaryDTO;
import ru.agasbek.learnapp.service.LanguageDictionaryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/language/dictionary")
public class LanguageDictionaryController {
    private final LanguageDictionaryService service;

    public LanguageDictionaryController(LanguageDictionaryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDictionaryDTO>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(LanguageDictionaryConverter::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDictionaryDTO> getById(@PathVariable long id) {
        var dict = service.getById(id);
        return dict.isPresent() ? ResponseEntity.ok(LanguageDictionaryConverter.toDTO(dict.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LanguageDictionaryDTO dto) {
        return ResponseEntity.ok(service.save(LanguageDictionaryConverter.toDomain(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LanguageDictionaryDTO dto) {
        return ResponseEntity.ok(service.update(LanguageDictionaryConverter.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
