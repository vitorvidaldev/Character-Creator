package dev.vitorvidal.characterCreator.application.service;

import dev.vitorvidal.characterCreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import dev.vitorvidal.characterCreator.domain.repository.AbilityScoreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class AbilityScoreService {

    private final AbilityScoreRepository abilityScoreRepository;

    public AbilityScoreService(AbilityScoreRepository abilityScoreRepository) {
        this.abilityScoreRepository = abilityScoreRepository;
    }

    public Iterable<AbilityScore> getAll() {
        return abilityScoreRepository.findAll();
    }

    public AbilityScore setAbilityScore(AbilityScore abilityScore) {
        return abilityScoreRepository.save(abilityScore);
    }

    public ResponseEntity<AbilityScore> getAbilityScoreById(UUID id) {
        Optional<AbilityScore> byId = abilityScoreRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return ResponseEntity.ok(byId.get());
    }

    public void deleteAbilityScore(UUID id) {
        abilityScoreRepository.deleteById(id);
    }

    public AbilityScoreVO levelUp() {
        return new AbilityScoreVO();
    }
}
