package dev.vitorvidal.charactercreator.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

//@Entity
public class PlayerCharacter {
    @Id
//    @Type(type = "pg-uuid")
    private UUID id;

    private String name;
    private int age;
    private Race race;
    private Job job;

    public PlayerCharacter(String name, int age, Race race, Job job) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.race = race;
        this.job = job;
    }

    public PlayerCharacter() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
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
