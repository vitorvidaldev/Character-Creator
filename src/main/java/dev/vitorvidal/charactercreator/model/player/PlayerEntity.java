package dev.vitorvidal.charactercreator.model.player;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Document("player")
public class PlayerEntity {
    @MongoId(FieldType.STRING)
    private UUID playerId;
    @NotNull
    private String name;
    @NotNull
    private int age;
    private AttributeVO attributes;
    private RaceEnum race;
    private JobEnum job;

    public PlayerEntity() {
    }

    public PlayerEntity(String name, int age, AttributeVO attributes, RaceEnum race, JobEnum job) {
        this.playerId = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.attributes = attributes;
        this.race = race;
        this.job = job;
    }
}
