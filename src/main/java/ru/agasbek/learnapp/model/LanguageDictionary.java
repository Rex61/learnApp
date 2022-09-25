package ru.agasbek.learnapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDictionary {
    @Id
    private long id;
    @OneToMany
    private List<LanguageCard> cards;
    private LocalDateTime lastSeen;
}
