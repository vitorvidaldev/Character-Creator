package dev.vitorvidal.characterCreator.domain.repository;

import dev.vitorvidal.characterCreator.domain.model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
}
