package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerService;
import dev.vitorvidal.charactercreator.model.player.CreatePlayerVO;
import dev.vitorvidal.charactercreator.model.player.PlayerVO;
import dev.vitorvidal.charactercreator.model.player.UpdatePlayerVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/rest/v1/players")
public record PlayerController(PlayerService playerService) {
    @PostMapping
    public ResponseEntity<PlayerVO> createPlayer(
            @RequestBody CreatePlayerVO createPlayerVO) {
        PlayerVO player = playerService.createPlayer(createPlayerVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerVO> getPlayerById(@PathVariable(value = "playerId") UUID playerId) {
        PlayerVO playerVO = playerService.getPlayerById(playerId);
        return ResponseEntity.ok().body(playerVO);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<PlayerVO> updatePlayer(
            @PathVariable(value = "playerId") UUID playerId,
            @RequestBody UpdatePlayerVO updatePlayerVO) {
        PlayerVO playerVO = playerService.updatePlayer(playerId, updatePlayerVO);
        return ResponseEntity.ok().body(playerVO);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable(value = "playerId") UUID playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }
}
