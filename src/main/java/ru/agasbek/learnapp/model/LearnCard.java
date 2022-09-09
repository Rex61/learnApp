package ru.agasbek.learnapp.model;

import java.time.LocalDateTime;

public class LearnCard {

    private final long id;
    private String word;
    private String description;


    public LearnCard(long id, String word, String description) {
        this.id = id;
        this.word = word;
        this.description = description;
    }

    public void increaseLearnTime() {
        // TODO работать через отдельный объект

    }
}
