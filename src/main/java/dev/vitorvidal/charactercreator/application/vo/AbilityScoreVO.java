package dev.vitorvidal.charactercreator.application.vo;

import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AbilityScoreVO {

    private UUID id;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public AbilityScore toModel() {
        return new AbilityScore(strength, dexterity, constitution, intelligence, wisdom, charisma);
    }
}