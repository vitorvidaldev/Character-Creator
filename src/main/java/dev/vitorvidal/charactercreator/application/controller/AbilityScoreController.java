package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.AbilityScoreService;
import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
        List<AbilityScore> all = abilityScoreService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping
    public ResponseEntity<AbilityScoreVO> setAbilityScore(@RequestBody AbilityScoreVO abilityScore) {
        AbilityScoreVO abilityScoreVO = abilityScoreService.setAbilityScore(abilityScore.toModel());
        return ResponseEntity.created(URI.create("/ability" + abilityScoreVO.getId().toString())).body(abilityScoreVO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityScoreVO> getAbilityScoreById(@PathVariable String id) {
        AbilityScoreVO abilityScoreById = abilityScoreService.getAbilityScoreById(id);
        return ResponseEntity.ok(abilityScoreById);
    }

    @DeleteMapping("/{id}")
    public void deleteAbilityScore(@PathVariable String id) {
        abilityScoreService.deleteAbilityScore(id);
    }
}
