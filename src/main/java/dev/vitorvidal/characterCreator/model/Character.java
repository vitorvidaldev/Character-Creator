package dev.vitorvidal.characterCreator.model;

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

    // TODO: Research how to implement data relationships in spring
    @ManyToOne
    private Ability ability;

    public Character(Race race, Class characterClass, Ability ability, String name, int age) {
        this.race = race;
        this.characterClass = characterClass;
        this.ability = ability;
        this.name = name;
        this.age = age;
    }

    public Character() {

    }
}
