package dev.vitorvidal.charactercreator.model.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record SignupVO(
        @NotNull
        @NotEmpty
        String username,
        @NotNull
        @NotEmpty
        @Email
        String email,
        @NotNull
        @NotEmpty
        String password
) {
}
