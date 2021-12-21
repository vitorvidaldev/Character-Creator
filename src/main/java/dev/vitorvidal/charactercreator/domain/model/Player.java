package dev.vitorvidal.charactercreator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Document("player")
public class Player {
    private ObjectId id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    private Attribute attribute;
    private Race race;
    private Job job;

    public Player() {}

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Player(String name, int age, Race race, Job job) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.job = job;
    }

    public Player(String name, int age, Attribute attribute) {
        this.name = name;
        this.age = age;
        this.attribute = attribute;
    }

    public Player(String name, int age, Attribute attribute, Race race, Job job) {
        this.name = name;
        this.age = age;
        this.attribute = attribute;
        this.race = race;
        this.job = job;
    }
}
