package dev.vitorvidal.charactercreator.model.player;

import javax.validation.constraints.NotNull;

public record CreatePlayerVO(
        @NotNull
        String name,
        @NotNull
        int age,
        @NotNull
        AttributeVO attributes,
        @NotNull
        RaceEnum race,
        @NotNull
        JobEnum job
) {
}
