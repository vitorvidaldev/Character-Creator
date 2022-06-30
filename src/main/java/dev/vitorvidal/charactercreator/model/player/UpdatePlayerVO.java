package dev.vitorvidal.charactercreator.model.player;

public record UpdatePlayerVO(
        String name,
        int age,
        AttributeVO attributeVO,
        Race race,
        Job job
) {
}
