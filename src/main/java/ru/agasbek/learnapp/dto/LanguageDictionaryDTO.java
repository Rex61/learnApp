package ru.agasbek.learnapp.dto;

import lombok.Builder;
import lombok.Data;
import ru.agasbek.learnapp.model.LanguageCard;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link ru.agasbek.learnapp.model.LanguageDictionary} entity
 */
@Data
@Builder
public class LanguageDictionaryDTO implements Serializable {
    private long id;
    private List<LanguageCard> cards;
    private LocalDateTime lastSeen;
}