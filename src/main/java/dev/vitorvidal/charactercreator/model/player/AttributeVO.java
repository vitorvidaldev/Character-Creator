package dev.vitorvidal.charactercreator.model.player;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record AttributeVO(
        @NotNull @Min(0) @Max(30)
        int strength,
        @NotNull @Min(0) @Max(30)
        int intelligence,
        @NotNull @Min(0) @Max(30)
        int wisdom,
        @NotNull @Min(0) @Max(30)
        int charisma,
        @NotNull @Min(0) @Max(30)
        int constitution,
        @NotNull @Min(0) @Max(30)
        int dexterity
) {
}