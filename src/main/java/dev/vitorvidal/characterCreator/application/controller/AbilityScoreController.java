package dev.vitorvidal.characterCreator.application.controller;

import dev.vitorvidal.characterCreator.application.service.AbilityScoreService;
import dev.vitorvidal.characterCreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.characterCreator.domain.model.AbilityScore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ability")
public class AbilityScoreController {

    private final AbilityScoreService abilityScoreService;

    // TODO: Fix http 406 "could not find acceptable representation" error
    public AbilityScoreController(AbilityScoreService abilityScoreService) {
        this.abilityScoreService = abilityScoreService;
    }

    @GetMapping
    public Iterable<AbilityScore> getAll() {
        return abilityScoreService.getAll();
    }

    @PostMapping
    public ResponseEntity<AbilityScoreVO> setAbilityScore(@RequestBody AbilityScore abilityScore) {
        return abilityScoreService.setAbilityScore(abilityScore);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityScoreVO> getAbilityScoreById(@PathVariable String id) {
        return abilityScoreService.getAbilityScoreById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAbilityScore(@PathVariable String id) {
        abilityScoreService.deleteAbilityScore(id);
    }
}
