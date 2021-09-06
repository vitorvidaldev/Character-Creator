package dev.vitorvidal.charactercreator.application.vo;

import dev.vitorvidal.charactercreator.domain.model.Job;
import dev.vitorvidal.charactercreator.domain.model.PlayerCharacter;
import dev.vitorvidal.charactercreator.domain.model.Race;

import java.util.UUID;

public class PlayerCharacterVO {

    private UUID id;
    private String name;
    private int age;
    private Race race;
    private Job job;

    public PlayerCharacter toModel() {
        return new PlayerCharacter(name, age, race, job);
    }

    public PlayerCharacterVO(UUID id, String name, int age, Race race, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.race = race;
        this.job = job;
    }

    public UUID getId() {
        return id;
    }
}
