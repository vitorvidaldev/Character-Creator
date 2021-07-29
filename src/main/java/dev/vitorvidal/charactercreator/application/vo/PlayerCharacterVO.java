package dev.vitorvidal.charactercreator.application.vo;

import dev.vitorvidal.charactercreator.domain.model.Job;
import dev.vitorvidal.charactercreator.domain.model.PlayerCharacter;
import dev.vitorvidal.charactercreator.domain.model.Race;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PlayerCharacterVO {

    private UUID id;
    private String name;
    private int age;
    private Race race;
    private Job job;

    public PlayerCharacter toModel() {
        return new PlayerCharacter(name, age, race, job);
    }
}
