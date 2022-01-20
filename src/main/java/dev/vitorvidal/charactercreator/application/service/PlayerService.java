package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.PlayerRepository;
import dev.vitorvidal.charactercreator.model.player.Attribute;
import dev.vitorvidal.charactercreator.model.player.PlayerEntity;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final DiceService diceService;

    public PlayerService(PlayerRepository playerRepository,
                         DiceService diceService) {
        this.playerRepository = playerRepository;
        this.diceService = diceService;
    }

    public ResponseEntity<List<PlayerEntity>> getAllPlayers() {
        List<PlayerEntity> playerEntities = playerRepository.findAll();
        return ResponseEntity.ok().body(playerEntities);
    }

    public ResponseEntity<PlayerEntity> createPlayer(PlayerEntity playerEntity) {
        var savedPlayer = playerRepository.save(playerEntity);
        return ResponseEntity.status(201).body(savedPlayer);
    }

    public ResponseEntity<PlayerEntity> getPlayerById(ObjectId id) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) {
            throw new NoSuchElementException();
        }
        return ResponseEntity.ok().body(optionalPlayer.get());
    }

    public ResponseEntity<PlayerEntity> updatePlayer(ObjectId id, PlayerEntity playerEntity) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) {
            throw new NoSuchElementException();
        }
        optionalPlayer.get().setName(playerEntity.getName());
        optionalPlayer.get().setAge(playerEntity.getAge());
        optionalPlayer.get().setRace(playerEntity.getRace());
        optionalPlayer.get().setJob(playerEntity.getJob());
        var updatedPlayer = playerRepository.save(optionalPlayer.get());
        return ResponseEntity.ok().body(updatedPlayer);
    }

    public ResponseEntity<Void> deletePlayer(ObjectId id) {
        playerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Attribute levelUp(String id) {
        Attribute attribute = new Attribute();

        attribute.updateStrength(diceService.d3());
        attribute.updateDexterity(diceService.d3());
        attribute.updateConstitution(diceService.d3());
        attribute.updateCharisma(diceService.d3());
        attribute.updateIntelligence(diceService.d3());
        attribute.updateWisdom(diceService.d3());

        return attribute;
    }
}
