package ru.agasbek.learnapp.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link ru.agasbek.learnapp.model.LearnCard} entity
 */
@Data
@Builder
public class LearnCardDTO implements Serializable {
    private long id;
    private int numberOfRepetitions;
    private LocalDateTime nextLearn;
    private boolean needToLearn;
    private String word;
    private String description;
}