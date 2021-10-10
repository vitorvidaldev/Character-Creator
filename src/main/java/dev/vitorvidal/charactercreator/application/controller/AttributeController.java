package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.AttributeService;
import dev.vitorvidal.charactercreator.domain.model.Attribute;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping
    public ResponseEntity<Attribute> setAttribute(@RequestBody @Valid Attribute body) {
        Attribute attributeVO = attributeService.setAttribute(body);
        return ResponseEntity.created(URI.create("/attribute" + attributeVO.getId())).body(attributeVO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getAttribute(@PathVariable String id) {
        Attribute abilityScoreById = attributeService.getAttribute(id);
        return ResponseEntity.ok(abilityScoreById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attribute> levelUp(@PathVariable String id) {
        Attribute attributeVO = attributeService.levelUp(id);
        return ResponseEntity.ok().body(attributeVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable String id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.ok().build();
    }
}
