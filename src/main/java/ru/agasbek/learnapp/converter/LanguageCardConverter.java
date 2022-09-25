package ru.agasbek.learnapp.converter;

import ru.agasbek.learnapp.dto.LanguageCardDTO;
import ru.agasbek.learnapp.model.LanguageCard;

public class LanguageCardConverter {
    public static LanguageCard toDomain(LanguageCardDTO dto) {
        return LanguageCard.builder()
                .id(dto.getId())
                .word(dto.getWord())
                .translation(dto.getTranslation())
                .needToLearn(dto.isNeedToLearn())
                .numberOfRepetitions(dto.getNumberOfRepetitions())
                .nextLearn(dto.getNextLearn())
                .build();
    }

    public static LanguageCardDTO toDTO(LanguageCard card) {
        return LanguageCardDTO.builder()
                .id(card.getId())
                .word(card.getWord())
                .translation(card.getTranslation())
                .needToLearn(card.isNeedToLearn())
                .numberOfRepetitions(card.getNumberOfRepetitions())
                .nextLearn(card.getNextLearn())
                .build();
    }
}
