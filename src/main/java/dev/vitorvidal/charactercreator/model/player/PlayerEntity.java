package dev.vitorvidal.charactercreator.model.player;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document("player")
public class PlayerEntity {
    private ObjectId id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    private Attribute attribute;
    private Race race;
    private Job job;

    public PlayerEntity() {
    }

    public PlayerEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PlayerEntity(String name, int age, Race race, Job job) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.job = job;
    }

    public PlayerEntity(String name, int age, Attribute attribute) {
        this.name = name;
        this.age = age;
        this.attribute = attribute;
    }

    public PlayerEntity(
            String name,
            int age,
            Attribute attribute,
            Race race,
            Job job) {
        this.name = name;
        this.age = age;
        this.attribute = attribute;
        this.race = race;
        this.job = job;
    }

    public ObjectId getId() {
        return id;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
