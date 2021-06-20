package dev.vitorvidal.characterCreator.domain.repository;

import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityScoreRepository extends JpaRepository<AbilityScore, String> {
}
