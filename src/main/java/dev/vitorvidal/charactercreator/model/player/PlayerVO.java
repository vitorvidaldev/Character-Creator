package dev.vitorvidal.charactercreator.model.player;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public record PlayerVO(
        UUID playerId,
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
