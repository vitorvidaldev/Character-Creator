package dev.vitorvidal.characterCreator.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @GetMapping
    public void getAll() {

    }

    @PostMapping
    public void createCharacter() {

    }

    @GetMapping("/{id}")
    public void getCharacterById(@PathVariable Long id) {

    }

    @PutMapping("/{id}")
    public void updateCharacter(@PathVariable Long id) {

    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {

    }
}
