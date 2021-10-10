package dev.vitorvidal.charactercreator.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document("player")
public class Player {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("age")
    private int age;
    @Field("race")
    private Race race;
    @Field("job")
    private Job job;

    public Player(String name, int age, Race race, Job job) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.race = race;
        this.job = job;
    }

    public Player() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
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
