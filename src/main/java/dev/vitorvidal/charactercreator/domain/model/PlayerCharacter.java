package dev.vitorvidal.charactercreator.domain.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class PlayerCharacter {
    @Id
    @Type(type = "pg-uuid")
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
}
