package dev.vitorvidal.characterCreator.application.controller;

import dev.vitorvidal.characterCreator.domain.ability.AbilityScore;
import dev.vitorvidal.characterCreator.domain.ability.AbilityScoreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ability")
public class AbilityScoreController {

    private final AbilityScoreRepository abilityScoreRepository;

    public AbilityScoreController(AbilityScoreRepository abilityScoreRepository) {
        this.abilityScoreRepository = abilityScoreRepository;
    }

    @GetMapping
    public Iterable<AbilityScore> getAll() {

        return abilityScoreRepository.findAll();
//        all.forEach(abilityScore -> );
    }

    @PostMapping
    public AbilityScore setAbilityScore(@RequestBody AbilityScore abilityScore) {
        return abilityScoreRepository.save(abilityScore);
    }

    @GetMapping("/{id}")
    public Optional<AbilityScore> getAbilityScoreById(@PathVariable Long id) {
        return abilityScoreRepository.findById(id);
    }

    @PutMapping("/{id}")
    public void updateAbilityScore(@PathVariable Long id) {

    }

    @DeleteMapping("/{id}")
    public void deleteAbilityScore(@PathVariable Long id) {

    }
}
