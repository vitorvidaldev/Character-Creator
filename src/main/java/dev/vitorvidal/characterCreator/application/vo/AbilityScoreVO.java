package dev.vitorvidal.characterCreator.application.vo;

import lombok.Data;

import java.util.UUID;

@Data
public class AbilityScoreVO {

    private UUID id;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public AbilityScoreVO() {
    }
}
