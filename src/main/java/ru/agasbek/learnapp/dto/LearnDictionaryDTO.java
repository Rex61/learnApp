package ru.agasbek.learnapp.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link ru.agasbek.learnapp.model.LearnDictionary} entity
 */
@Data
@Builder
public class LearnDictionaryDTO implements Serializable {
    private long id;
    private LocalDateTime lastSeen;
}