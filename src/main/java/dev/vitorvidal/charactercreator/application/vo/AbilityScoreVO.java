package dev.vitorvidal.charactercreator.application.vo;

import dev.vitorvidal.charactercreator.domain.model.Attribute;

public class AbilityScoreVO {

    private String id;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Attribute toModel() {
        return new Attribute(strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public AbilityScoreVO(String id, int strength, int dexterity, int constitution, int intelligence, int wisdom,
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

    public String getId() {
        return id;
    }
}