package ru.agasbek.learnapp.dto;

import lombok.Builder;
import lombok.Data;
import ru.agasbek.learnapp.model.LearnCard;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link ru.agasbek.learnapp.model.LearnDictionary} entity
 */
@Data
@Builder
public class LearnDictionaryDTO implements Serializable {
    private long id;
    private List<LearnCard> cards;
    private LocalDateTime lastSeen;
}