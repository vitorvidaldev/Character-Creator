package dev.vitorvidal.charactercreator.application.repository;

import dev.vitorvidal.charactercreator.model.player.PlayerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends MongoRepository<PlayerEntity, UUID> {
}
