package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.AbilityScoreService;
import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ability")
public class AbilityScoreController {

    private final AbilityScoreService abilityScoreService;

    public AbilityScoreController(AbilityScoreService abilityScoreService) {
        this.abilityScoreService = abilityScoreService;
    }

    @GetMapping
    public ResponseEntity<List<AbilityScore>> getAll() {
        return abilityScoreService.getAll();
    }

    @PostMapping
    public ResponseEntity<AbilityScoreVO> setAbilityScore(@RequestBody AbilityScoreVO abilityScore) {
        return abilityScoreService.setAbilityScore(abilityScore.toModel());
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
