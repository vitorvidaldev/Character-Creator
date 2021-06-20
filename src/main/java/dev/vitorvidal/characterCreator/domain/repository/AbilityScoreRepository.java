package dev.vitorvidal.characterCreator.domain.repository;

import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbilityScoreRepository extends CrudRepository<AbilityScore, UUID> {
}
