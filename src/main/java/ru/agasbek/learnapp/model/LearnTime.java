package ru.agasbek.learnapp.model;

import java.time.LocalDateTime;

public class LearnTime {
    private final int maxRepetitions;
    private long id;
    private LocalDateTime nextLearn;
    private int numberOfRepetitions = 0;

    public LearnTime(int maxRepetitions, LocalDateTime lastDateTime) {
        this.maxRepetitions = maxRepetitions;
    }

    public void increase() {

    }

    public boolean needToLearn() {
        return true;
    }
}
