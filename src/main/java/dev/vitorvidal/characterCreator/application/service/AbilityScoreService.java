package dev.vitorvidal.characterCreator.application.service;

import dev.vitorvidal.characterCreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import dev.vitorvidal.characterCreator.domain.repository.AbilityScoreRepository;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<AbilityScoreVO> setAbilityScore(AbilityScore abilityScore) {
        AbilityScore save = abilityScoreRepository.save(abilityScore);
        return new ResponseEntity<AbilityScoreVO>(save.toVO(), HttpStatus.CREATED);
    }

    public ResponseEntity<AbilityScoreVO> getAbilityScoreById(String id) {
        Optional<AbilityScore> byId = abilityScoreRepository.findById(UUID.fromString(id));
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return ResponseEntity.ok(byId.get().toVO());
    }

    public void deleteAbilityScore(String id) {
        try {
            abilityScoreRepository.deleteById(UUID.fromString(id));
        } catch (Exception e) {
            throw new NoSuchElementException("No element with the provided id exists.");
        }
    }

    // TODO: Design and implement
    public AbilityScoreVO levelUp() {
        return new AbilityScoreVO();
    }
}
