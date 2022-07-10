package dev.vitorvidal.charactercreator.model.player;

import javax.validation.constraints.NotNull;

public record PlayerVO(
        Object Id,
        @NotNull
        String name,
        @NotNull
        int age,
        @NotNull
        AttributeVO attributeVO,
        RaceEnum race,
        JobEnum job
) {
}
