package ru.agasbek.learnapp.converter;

import ru.agasbek.learnapp.dto.LearnDictionaryDTO;
import ru.agasbek.learnapp.model.LearnDictionary;

public class LearnDictionaryConverter {
    public static LearnDictionary toDomain(LearnDictionaryDTO dto) {
        return LearnDictionary.builder()
                .id(dto.getId())
                .lastSeen(dto.getLastSeen())
                .build();
    }

    public static LearnDictionaryDTO toDTO(LearnDictionary dict) {
        return LearnDictionaryDTO.builder()
                .id(dict.getId())
                .lastSeen(dict.getLastSeen())
                .build();
    }
}
