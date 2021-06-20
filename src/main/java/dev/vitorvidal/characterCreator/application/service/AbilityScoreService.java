package dev.vitorvidal.characterCreator.application.service;

import dev.vitorvidal.characterCreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import dev.vitorvidal.characterCreator.domain.repository.AbilityScoreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AbilityScoreService {

    private final AbilityScoreRepository abilityScoreRepository;

    public AbilityScoreService(AbilityScoreRepository abilityScoreRepository) {
        this.abilityScoreRepository = abilityScoreRepository;
    }

    public Iterable<AbilityScore> getAll() {

        return abilityScoreRepository.findAll();
//        all.forEach(abilityScore -> );
    }

    public AbilityScore setAbilityScore(AbilityScore abilityScore) {
        return abilityScoreRepository.save(abilityScore);
    }

    public Optional<AbilityScore> getAbilityScoreById(Long id) {
        return abilityScoreRepository.findById(id);
    }

    public void deleteAbilityScore(Long id) {
        abilityScoreRepository.deleteById(id);
    }

    public AbilityScoreVO levelUp() {
        return new AbilityScoreVO();
    }
}
