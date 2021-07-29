package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerCharacterService;
import dev.vitorvidal.charactercreator.application.vo.PlayerCharacterVO;
import dev.vitorvidal.charactercreator.domain.model.PlayerCharacter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/playerCharacter")
public class PlayerCharacterController {

    private final PlayerCharacterService playerCharacterService;

    public PlayerCharacterController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerCharacter>> getAll() {
        return playerCharacterService.getAll();
    }

    @PostMapping
    public ResponseEntity<PlayerCharacter> createCharacter(@RequestBody PlayerCharacterVO vo) {
        return playerCharacterService.createCharacter(vo.toModel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerCharacter> getCharacterById(@PathVariable String id) {
        return playerCharacterService.getCharacterById(UUID.fromString(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerCharacter> updateCharacter(@PathVariable String id, @RequestBody PlayerCharacterVO vo) {
        return playerCharacterService.updateCharacter(UUID.fromString(id), vo.toModel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String id) {
        return playerCharacterService.deleteCharacter(UUID.fromString(id));
    }
}
