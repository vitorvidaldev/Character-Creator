package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import dev.vitorvidal.charactercreator.domain.repository.AbilityScoreRepository;
import org.springframework.stereotype.Service;

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

    public List<AbilityScore> getAll() {
        return (List<AbilityScore>) abilityScoreRepository.findAll();
    }

    public AbilityScoreVO setAbilityScore(AbilityScore abilityScore) {
        return abilityScoreRepository.save(abilityScore).toVO();
    }

    public AbilityScoreVO getAbilityScoreById(String id) {
        Optional<AbilityScore> byId = abilityScoreRepository.findById(UUID.fromString(id));
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return byId.get().toVO();
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
