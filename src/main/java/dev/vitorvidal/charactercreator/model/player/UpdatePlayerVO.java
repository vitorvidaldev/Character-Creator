package dev.vitorvidal.charactercreator.model.player;

public record UpdatePlayerVO(
        String name,
        int age,
        AttributeVO attributeVO,
        RaceEnum race,
        JobEnum job
) {
}
