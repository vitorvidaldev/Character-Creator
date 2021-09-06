package dev.vitorvidal.charactercreator.application.vo;

import dev.vitorvidal.charactercreator.domain.model.AbilityScore;

import java.util.UUID;

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

    public AbilityScoreVO(UUID id, int strength, int dexterity, int constitution, int intelligence, int wisdom,
            int charisma) {
        this.id = id;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public AbilityScoreVO() {
    }

    public UUID getId() {
        return id;
    }
}