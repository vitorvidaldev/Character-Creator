package dev.vitorvidal.characterCreator.application.service;

import dev.vitorvidal.characterCreator.domain.model.Character;
import dev.vitorvidal.characterCreator.domain.repository.CharacterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public ResponseEntity<List<Character>> getAll() {
        List<Character> all = (List<Character>) characterRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    public ResponseEntity<Character> createCharacter(Character character) {
        Character save = characterRepository.save(character);
        return ResponseEntity.created(URI.create("/character" + save.getId().toString())).body(save);
    }

    public ResponseEntity<Character> getCharacterById(UUID id) {
        Optional<Character> byId = characterRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return ResponseEntity.ok().body(byId.get());
    }

    public ResponseEntity<Character> updateCharacter(UUID id, Character character) {
        Optional<Character> byId = characterRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        byId.get().setName(character.getName());
        byId.get().setAge(character.getAge());
        byId.get().setRace(character.getRace());
        byId.get().setCharacterClass(character.getCharacterClass());
        Character save = characterRepository.save(byId.get());
        return ResponseEntity.ok().body(save);
    }

    public ResponseEntity<Void> deleteCharacter(UUID id) {
        characterRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
