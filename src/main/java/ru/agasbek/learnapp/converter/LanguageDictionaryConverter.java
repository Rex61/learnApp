package ru.agasbek.learnapp.converter;

import ru.agasbek.learnapp.dto.LanguageDictionaryDTO;
import ru.agasbek.learnapp.model.LanguageDictionary;

public class LanguageDictionaryConverter {
    public static LanguageDictionary toDomain(LanguageDictionaryDTO dto) {
        return LanguageDictionary.builder()
                .id(dto.getId())
                .lastSeen(dto.getLastSeen())
                .build();
    }

    public static LanguageDictionaryDTO toDTO(LanguageDictionary dict) {
        return LanguageDictionaryDTO.builder()
                .id(dict.getId())
                .lastSeen(dict.getLastSeen())
                .build();
    }
}
