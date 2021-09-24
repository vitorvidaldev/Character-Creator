package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.AttributeService;
import dev.vitorvidal.charactercreator.application.vo.AttributeVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping
    public ResponseEntity<AttributeVO> setAttribute(@RequestBody AttributeVO abilityScore) {
        AttributeVO attributeVO = attributeService.setAttribute(abilityScore.toModel());
        return ResponseEntity.created(URI.create("/attribute" + attributeVO.getId())).body(attributeVO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeVO> getAttribute(@PathVariable String id) {
        AttributeVO abilityScoreById = attributeService.getAttributeVO(id);
        return ResponseEntity.ok(abilityScoreById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeVO> levelUp(@PathVariable String id) {
        AttributeVO attributeVO = attributeService.levelUp(id);
        return ResponseEntity.ok().body(attributeVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable String id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.ok().build();
    }
}
