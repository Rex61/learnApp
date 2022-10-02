package ru.agasbek.learnapp.dto;

import lombok.Builder;
import lombok.Data;
import ru.agasbek.learnapp.model.LearnCard;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link ru.agasbek.learnapp.model.LearnDictionary} entity
 */
@Data
@Builder
public class LearnDictionaryDTO implements Serializable {
    private long id;
    private Set<LearnCard> cards;
    private LocalDateTime lastSeen;
}