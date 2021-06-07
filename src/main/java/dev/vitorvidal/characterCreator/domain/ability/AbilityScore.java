package dev.vitorvidal.characterCreator.domain.ability;

import javax.persistence.*;

@Entity
@Table(name = "ability_score")
public class AbilityScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
//
//    @OneToMany(mappedBy = "ability_score")
//    private static final List<Character> characters = new ArrayList<>();

    public AbilityScore(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public AbilityScore() {

    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }
}
