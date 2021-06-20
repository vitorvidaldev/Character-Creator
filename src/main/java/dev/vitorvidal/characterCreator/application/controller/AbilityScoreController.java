package dev.vitorvidal.characterCreator.application.controller;

import dev.vitorvidal.characterCreator.application.service.AbilityScoreService;
import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ability")
public class AbilityScoreController {

    private final AbilityScoreService abilityScoreService;

    public AbilityScoreController(AbilityScoreService abilityScoreService) {
        this.abilityScoreService = abilityScoreService;
    }

    @GetMapping
    public Iterable<AbilityScore> getAll() {
        return abilityScoreService.getAll();
    }

    @PostMapping
    public AbilityScore setAbilityScore(@RequestBody AbilityScore abilityScore) {
        return abilityScoreService.setAbilityScore(abilityScore);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityScore> getAbilityScoreById(@PathVariable String id) {
        return abilityScoreService.getAbilityScoreById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAbilityScore(@PathVariable String id) {
        abilityScoreService.deleteAbilityScore(id);
    }
}
