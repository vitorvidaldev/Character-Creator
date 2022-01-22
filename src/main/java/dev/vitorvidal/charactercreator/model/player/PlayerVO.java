package dev.vitorvidal.charactercreator.model.player;

import javax.validation.constraints.NotNull;

public record PlayerVO(
        Object Id,
        @NotNull
        String name,
        @NotNull
        int age,
        @NotNull
        Attribute attribute,
        Race race,
        Job job
) {
}
