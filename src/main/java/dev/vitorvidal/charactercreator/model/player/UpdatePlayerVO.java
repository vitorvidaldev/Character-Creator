package dev.vitorvidal.charactercreator.model.player;

public record UpdatePlayerVO(
        String name,
        int age,
        AttributeOld attributeOld,
        Race race,
        Job job
) {
}
