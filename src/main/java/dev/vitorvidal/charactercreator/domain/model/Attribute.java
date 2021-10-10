package dev.vitorvidal.charactercreator.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("attribute")
public class Attribute {
    @Field("strength")
    private int strength;
    @Field("dexterity")
    private int dexterity;
    @Field("constitution")
    private int constitution;
    @Field("intelligence")
    private int intelligence;
    @Field("wisdom")
    private int wisdom;
    @Field("charisma")
    private int charisma;

    public Attribute(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
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
}