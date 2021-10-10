package dev.vitorvidal.charactercreator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Attribute {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Attribute() {}

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
}