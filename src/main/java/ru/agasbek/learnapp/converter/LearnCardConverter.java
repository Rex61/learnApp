package ru.agasbek.learnapp.converter;

import ru.agasbek.learnapp.dto.LearnCardDTO;
import ru.agasbek.learnapp.model.LearnCard;

public class LearnCardConverter {
    public static LearnCard toDomain(LearnCardDTO dto) {
        return LearnCard.builder()
                .id(dto.getId())
                .word(dto.getWord())
                .description(dto.getDescription())
                .needToLearn(dto.isNeedToLearn())
                .numberOfRepetitions(dto.getNumberOfRepetitions())
                .nextLearn(dto.getNextLearn())
                .build();
    }

    public static LearnCardDTO toDTO(LearnCard card) {
        return LearnCardDTO.builder()
                .id(card.getId())
                .word(card.getWord())
                .description(card.getDescription())
                .needToLearn(card.isNeedToLearn())
                .numberOfRepetitions(card.getNumberOfRepetitions())
                .nextLearn(card.getNextLearn())
                .build();
    }
}
