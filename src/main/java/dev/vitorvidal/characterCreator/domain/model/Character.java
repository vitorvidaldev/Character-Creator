package dev.vitorvidal.characterCreator.domain.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Character {
    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    private String name;
    private int age;
    private Race race;
    private Class characterClass;

    public Character(Race race, Class characterClass, String name, int age) {
        this.race = race;
        this.characterClass = characterClass;
        this.name = name;
        this.age = age;
    }

    public Character() {

    }
}
