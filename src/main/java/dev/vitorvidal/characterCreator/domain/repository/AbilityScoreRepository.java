package dev.vitorvidal.characterCreator.domain.repository;

import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityScoreRepository extends CrudRepository<AbilityScore, Long> {
}
