package dev.vitorvidal.charactercreator.application.repository;

import dev.vitorvidal.charactercreator.model.player.PlayerEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<PlayerEntity, ObjectId> {
}
