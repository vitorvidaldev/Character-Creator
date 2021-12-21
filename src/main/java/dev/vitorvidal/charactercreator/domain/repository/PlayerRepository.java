package dev.vitorvidal.charactercreator.domain.repository;

import dev.vitorvidal.charactercreator.domain.model.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, ObjectId> {
}
