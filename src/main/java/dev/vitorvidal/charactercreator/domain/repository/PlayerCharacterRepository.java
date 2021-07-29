package dev.vitorvidal.charactercreator.domain.repository;

import dev.vitorvidal.charactercreator.domain.model.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerCharacterRepository extends CrudRepository<PlayerCharacter, UUID> {
}
