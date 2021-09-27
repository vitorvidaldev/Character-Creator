package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.domain.model.Player;
import dev.vitorvidal.charactercreator.domain.repository.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public ResponseEntity<List<Player>> getAll() {
        List<Player> all = playerRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    public ResponseEntity<Player> createCharacter(Player player) {
        var save = playerRepository.save(player);
        return ResponseEntity.created(URI.create("/character" + save.getId())).body(save);
    }

    public ResponseEntity<Player> getCharacterById(UUID id) {
        Optional<Player> byId = playerRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return ResponseEntity.ok().body(byId.get());
    }

    public ResponseEntity<Player> updateCharacter(UUID id, Player player) {
        Optional<Player> byId = playerRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        byId.get().setName(player.getName());
        byId.get().setAge(player.getAge());
        byId.get().setRace(player.getRace());
        byId.get().setJob(player.getJob());
        var save = playerRepository.save(byId.get());
        return ResponseEntity.ok().body(save);
    }

    public ResponseEntity<Void> deleteCharacter(UUID id) {
        playerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
