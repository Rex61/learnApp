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
public class LanguageCard extends Card{
    private String word;
    private String translation;

    @ManyToOne
    @JoinColumn(name = "dictionary_id", nullable = false)
    private LanguageDictionary dictionary;

    @Builder
    public LanguageCard(long id, int numberOfRepetitions, LocalDateTime nextLearn, boolean needToLearn, String word, String translation) {
        super(id, numberOfRepetitions, nextLearn, needToLearn);
        this.word = word;
        this.translation = translation;
    }
}
