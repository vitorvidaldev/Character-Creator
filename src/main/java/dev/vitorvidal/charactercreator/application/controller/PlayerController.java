package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerService;
import dev.vitorvidal.charactercreator.domain.model.Player;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Player> getCharacterById(@PathVariable ObjectId id) {
        return playerService.getCharacterById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updateCharacter(@PathVariable ObjectId id, @RequestBody Player player) {
        return playerService.updateCharacter(id, player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable ObjectId id) {
        return playerService.deleteCharacter(id);
    }
}
