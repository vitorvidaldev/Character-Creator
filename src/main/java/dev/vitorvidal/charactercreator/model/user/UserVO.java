package dev.vitorvidal.charactercreator.model.user;

import java.util.UUID;

public record UserVO(UUID userId, String username, String email) {
}