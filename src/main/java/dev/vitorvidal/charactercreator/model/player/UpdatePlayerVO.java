package dev.vitorvidal.charactercreator.model.player;

public record UpdatePlayerVO(
        String name,
        int age,
        Attribute attribute,
        Race race,
        Job job
) {
}
