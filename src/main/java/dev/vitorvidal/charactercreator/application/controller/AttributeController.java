package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.AttributeService;
import dev.vitorvidal.charactercreator.application.vo.AttributeVO;
import dev.vitorvidal.charactercreator.domain.model.Attribute;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping
    public ResponseEntity<List<AttributeVO>> getAll() {
        List<Attribute> attributes = attributeService.getAll();
        return ResponseEntity.ok().body(attributes.stream().map(Attribute::toVO).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<AttributeVO> setAbilityScore(@RequestBody AttributeVO abilityScore) {
        AttributeVO attributeVO = attributeService.setAttribute(abilityScore.toModel());
        return ResponseEntity.created(URI.create("/attribute" + attributeVO.getId().toString())).body(attributeVO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeVO> getAbilityScoreById(@PathVariable String id) {
        AttributeVO abilityScoreById = attributeService.getAttributeVO(id);
        return ResponseEntity.ok(abilityScoreById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeVO> levelUp(@PathVariable String id) {
        AttributeVO attributeVO = attributeService.levelUp(id);
        return ResponseEntity.ok().body(attributeVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbilityScore(@PathVariable String id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.ok().build();
    }
}
