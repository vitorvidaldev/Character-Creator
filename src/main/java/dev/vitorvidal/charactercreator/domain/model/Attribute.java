package dev.vitorvidal.charactercreator.domain.model;

import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;

import java.util.UUID;

public class Attribute {
    private final String id;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Attribute() {
        this.id = UUID.randomUUID().toString();
    }

    public Attribute(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.id = UUID.randomUUID().toString();
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public void updateStrength(int strength) {
        this.strength += strength;
    }

    public void updateDexterity(int dexterity) {
        this.dexterity += dexterity;
    }

    public void updateConstitution(int constitution) {
        this.constitution += constitution;
    }

    public void updateIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    public void updateWisdom(int wisdom) {
        this.wisdom += wisdom;
    }

    public void updateCharisma(int charisma) {
        this.charisma += charisma;
    }

    public void levelUp() {
        this.strength += 2;
        this.dexterity += 2;
        this.constitution += 2;
        this.intelligence += 2;
        this.wisdom += 2;
        this.charisma += 2;
    }

    public AbilityScoreVO toVO() {
        return new AbilityScoreVO(id, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public String getId() {
        return id;
    }
}