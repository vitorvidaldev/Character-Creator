package dev.vitorvidal.charactercreator.domain.model;

import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class AbilityScore {
    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public AbilityScore() {
        this.id = UUID.randomUUID();
    }

    public AbilityScore(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.id = UUID.randomUUID();
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
        var vo = new AbilityScoreVO(id, strength, dexterity, constitution, intelligence, wisdom, charisma);
        return vo;
    }

    public UUID getId() {
        return id;
    }
}
