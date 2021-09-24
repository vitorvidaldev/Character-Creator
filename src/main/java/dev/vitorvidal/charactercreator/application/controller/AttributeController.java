package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.AttributeService;
import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.charactercreator.domain.model.Attribute;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping
    public ResponseEntity<List<Attribute>> getAll() {
        List<Attribute> all = attributeService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping
    public ResponseEntity<AbilityScoreVO> setAbilityScore(@RequestBody AbilityScoreVO abilityScore) {
        AbilityScoreVO abilityScoreVO = attributeService.setAbilityScore(abilityScore.toModel());
        return ResponseEntity.created(URI.create("/attribute" + abilityScoreVO.getId().toString())).body(abilityScoreVO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityScoreVO> getAbilityScoreById(@PathVariable String id) {
        AbilityScoreVO abilityScoreById = attributeService.getAbilityScoreById(id);
        return ResponseEntity.ok(abilityScoreById);
    }

    @DeleteMapping("/{id}")
    public void deleteAbilityScore(@PathVariable String id) {
        attributeService.deleteAbilityScore(id);
    }
}
