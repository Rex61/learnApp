package ru.agasbek.learnapp.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LanguageCard extends Card{
    private String word;
    private String translation;

    @Builder
    public LanguageCard(long id, int numberOfRepetitions, LocalDateTime nextLearn, boolean needToLearn, String word, String translation) {
        super(id, numberOfRepetitions, nextLearn, needToLearn);
        this.word = word;
        this.translation = translation;
    }
}
