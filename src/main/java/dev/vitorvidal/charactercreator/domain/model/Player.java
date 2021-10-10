package dev.vitorvidal.charactercreator.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document("player")
public class Player {
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Race getRace() {
        return race;
    }

    public Job getJob() {
        return job;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
