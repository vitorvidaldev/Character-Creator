package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerService;
import dev.vitorvidal.charactercreator.model.player.CreatePlayerVO;
import dev.vitorvidal.charactercreator.model.player.PlayerVO;
import dev.vitorvidal.charactercreator.model.player.UpdatePlayerVO;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<PlayerVO>> getAllPlayers() {
        List<PlayerVO> playerList = playerService.getAllPlayers();
        return ResponseEntity.ok().body(playerList);
    }

    @PostMapping
    public ResponseEntity<PlayerVO> createPlayer(
            @RequestBody CreatePlayerVO createPlayerVO) {
        PlayerVO player = playerService.createPlayer(createPlayerVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerVO> getPlayerById(
            @PathVariable ObjectId id) {
        PlayerVO playerVO = playerService.getPlayerById(id);
        return ResponseEntity.ok().body(playerVO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerVO> updatePlayer(
            @PathVariable ObjectId id,
            @RequestBody UpdatePlayerVO updatePlayerVO) {
        PlayerVO playerVO = playerService.updatePlayer(id, updatePlayerVO);
        return ResponseEntity.ok().body(playerVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable ObjectId id) {
        return playerService.deletePlayer(id);
    }
}
