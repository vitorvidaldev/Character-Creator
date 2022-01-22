package dev.vitorvidal.charactercreator.model.player;

import javax.validation.constraints.NotNull;

public record CreatePlayerVO(
        @NotNull
        String name,
        @NotNull
        int age
) {
}
