package ru.agasbek.learnapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LearnCard extends Card{
    private String word;
    private String description;

    @ManyToOne
    @JoinColumn(name = "dictionary_id", nullable = false)
    private LearnDictionary dictionary;

    @Builder
    public LearnCard(long id, int numberOfRepetitions, LocalDateTime nextLearn, boolean needToLearn, String word, String description) {
        super(id, numberOfRepetitions, nextLearn, needToLearn);
        this.word = word;
        this.description = description;
    }
}
