package dev.vitorvidal.characterCreator.domain.ability;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityScoreRepository extends CrudRepository<AbilityScore, Long> {
}
