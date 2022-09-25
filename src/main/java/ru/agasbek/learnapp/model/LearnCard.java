package ru.agasbek.learnapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LearnCard extends Card{
    private String word;
    private String description;

    @Builder
    public LearnCard(long id, int numberOfRepetitions, LocalDateTime nextLearn, boolean needToLearn, String word, String description) {
        super(id, numberOfRepetitions, nextLearn, needToLearn);
        this.word = word;
        this.description = description;
    }
}
