package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerService;
import dev.vitorvidal.charactercreator.domain.model.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAll() {
        return playerService.getAll();
    }

    @PostMapping
    public ResponseEntity<Player> createCharacter(@RequestBody Player player) {
        return playerService.createCharacter(player);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getCharacterById(@PathVariable String id) {
        return playerService.getCharacterById(UUID.fromString(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updateCharacter(@PathVariable String id, @RequestBody Player player) {
        return playerService.updateCharacter(UUID.fromString(id), player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String id) {
        return playerService.deleteCharacter(UUID.fromString(id));
    }
}
