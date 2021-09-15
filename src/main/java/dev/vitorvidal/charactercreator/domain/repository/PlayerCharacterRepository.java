package dev.vitorvidal.charactercreator.domain.repository;

import dev.vitorvidal.charactercreator.domain.model.PlayerCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

//@Repository
public interface PlayerCharacterRepository extends MongoRepository<PlayerCharacter, UUID> {
}
