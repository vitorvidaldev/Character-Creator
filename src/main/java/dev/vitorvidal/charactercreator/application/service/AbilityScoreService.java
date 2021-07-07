package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import dev.vitorvidal.charactercreator.domain.repository.AbilityScoreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class AbilityScoreService {

    private final AbilityScoreRepository abilityScoreRepository;

    public AbilityScoreService(AbilityScoreRepository abilityScoreRepository) {
        this.abilityScoreRepository = abilityScoreRepository;
    }

    public ResponseEntity<List<AbilityScore>> getAll() {
        List<AbilityScore> all = (List<AbilityScore>) abilityScoreRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    public ResponseEntity<AbilityScoreVO> setAbilityScore(AbilityScore abilityScore) {
        var save = abilityScoreRepository.save(abilityScore);
        return ResponseEntity.created(URI.create("/ability" + save.getId().toString())).body(save.toVO());
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
