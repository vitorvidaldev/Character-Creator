package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerService;
import dev.vitorvidal.charactercreator.model.player.PlayerEntity;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerEntity>> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public ResponseEntity<PlayerEntity> createPlayer(@RequestBody PlayerEntity playerEntity) {
        return playerService.createPlayer(playerEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerEntity> getPlayerById(@PathVariable ObjectId id) {
        return playerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerEntity> updatePlayer(@PathVariable ObjectId id,
                                                     @RequestBody PlayerEntity playerEntity) {
        return playerService.updatePlayer(id, playerEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable ObjectId id) {
        return playerService.deletePlayer(id);
    }
}
