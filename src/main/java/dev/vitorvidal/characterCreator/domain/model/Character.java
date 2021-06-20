package dev.vitorvidal.characterCreator.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Character {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private int age;
    private Race race;
    private Class characterClass;

//    @ManyToOne
//    @JoinColumn(name = "ability_score_id")
//    private AbilityScore abilityScore;

    public Character(Race race, Class characterClass, AbilityScore abilityScore, String name, int age) {
        this.race = race;
        this.characterClass = characterClass;
        this.name = name;
        this.age = age;
    }

    public Character() {

    }
}
