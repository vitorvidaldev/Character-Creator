package dev.vitorvidal.charactercreator.application.vo;

import dev.vitorvidal.charactercreator.domain.model.Job;
import dev.vitorvidal.charactercreator.domain.model.Player;
import dev.vitorvidal.charactercreator.domain.model.Race;

public class PlayerCharacterVO {
    private String id;
    private String name;
    private int age;
    private Race race;
    private Job job;

    public Player toModel() {
        return new Player(name, age, race, job);
    }

    public PlayerCharacterVO(String id, String name, int age, Race race, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.race = race;
        this.job = job;
    }

    public String getId() {
        return id;
    }
}
