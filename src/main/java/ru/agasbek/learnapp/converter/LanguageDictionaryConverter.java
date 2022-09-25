package ru.agasbek.learnapp.converter;

import ru.agasbek.learnapp.dto.LanguageDictionaryDTO;
import ru.agasbek.learnapp.model.LanguageDictionary;

public class LanguageDictionaryConverter {
    public static LanguageDictionary toDomain(LanguageDictionaryDTO dto) {
        return LanguageDictionary.builder()
                .id(dto.getId())
                .cards(dto.getCards())
                .lastSeen(dto.getLastSeen())
                .build();
    }

    public static LanguageDictionaryDTO toDTO(LanguageDictionary dict) {
        return LanguageDictionaryDTO.builder()
                .id(dict.getId())
                .cards(dict.getCards())
                .lastSeen(dict.getLastSeen())
                .build();
    }
}
