package dev.vitorvidal.charactercreator.domain.repository;

import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

//@Repository
public interface AbilityScoreRepository extends MongoRepository<AbilityScore, UUID> {
}
