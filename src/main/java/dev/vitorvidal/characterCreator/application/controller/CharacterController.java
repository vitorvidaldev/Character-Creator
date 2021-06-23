package dev.vitorvidal.characterCreator.application.controller;

import dev.vitorvidal.characterCreator.application.service.CharacterService;
import dev.vitorvidal.characterCreator.domain.model.Character;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<List<Character>> getAll() {
        return characterService.getAll();
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable String id) {
        return characterService.getCharacterById(UUID.fromString(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable String id, @RequestBody Character character) {
        return characterService.updateCharacter(UUID.fromString(id), character);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String id) {
        return characterService.deleteCharacter(UUID.fromString(id));
    }
}
