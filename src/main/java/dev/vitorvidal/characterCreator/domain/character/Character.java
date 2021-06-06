package dev.vitorvidal.characterCreator.domain.character;

import dev.vitorvidal.characterCreator.domain.ability.AbilityScore;
import dev.vitorvidal.characterCreator.model.Class;
import dev.vitorvidal.characterCreator.model.Race;

import javax.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Race race;
    private Class characterClass;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "ability_score_id")
    private AbilityScore abilityScore;

    public Character(Race race, Class characterClass, AbilityScore abilityScore, String name, int age) {
        this.race = race;
        this.characterClass = characterClass;
        this.abilityScore = abilityScore;
        this.name = name;
        this.age = age;
    }

    public Character() {

    }
}
