package dev.vitorvidal.charactercreator.model.user;

import org.bson.types.ObjectId;

public record UserVO(
        ObjectId id,
        String username,
        String email
) {
}
