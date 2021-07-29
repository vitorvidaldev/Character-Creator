package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.domain.model.PlayerCharacter;
import dev.vitorvidal.charactercreator.domain.repository.PlayerCharacterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerCharacterService {

    private final PlayerCharacterRepository playerCharacterRepository;

    public PlayerCharacterService(PlayerCharacterRepository playerCharacterRepository) {
        this.playerCharacterRepository = playerCharacterRepository;
    }

    public ResponseEntity<List<PlayerCharacter>> getAll() {
        List<PlayerCharacter> all = (List<PlayerCharacter>) playerCharacterRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    public ResponseEntity<PlayerCharacter> createCharacter(PlayerCharacter playerCharacter) {
        var save = playerCharacterRepository.save(playerCharacter);
        return ResponseEntity.created(URI.create("/character" + save.getId().toString())).body(save);
    }

    public ResponseEntity<PlayerCharacter> getCharacterById(UUID id) {
        Optional<PlayerCharacter> byId = playerCharacterRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return ResponseEntity.ok().body(byId.get());
    }

    public ResponseEntity<PlayerCharacter> updateCharacter(UUID id, PlayerCharacter playerCharacter) {
        Optional<PlayerCharacter> byId = playerCharacterRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        byId.get().setName(playerCharacter.getName());
        byId.get().setAge(playerCharacter.getAge());
        byId.get().setRace(playerCharacter.getRace());
        byId.get().setJob(playerCharacter.getJob());
        var save = playerCharacterRepository.save(byId.get());
        return ResponseEntity.ok().body(save);
    }

    public ResponseEntity<Void> deleteCharacter(UUID id) {
        playerCharacterRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
