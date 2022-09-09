package ru.agasbek.learnapp.model;

import java.time.LocalDateTime;

public class LanguageCard {
    private final long id;
    private String word;
    private String translation;
    private LocalDateTime nextLearn;

    public LanguageCard(long id, String word, String translation) {
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.nextLearn = LocalDateTime.now();
    }
}
