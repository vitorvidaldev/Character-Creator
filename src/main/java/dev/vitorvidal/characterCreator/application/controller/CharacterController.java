package dev.vitorvidal.characterCreator.application.controller;

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
    public void getCharacterById(@PathVariable String id) {

    }

    @PutMapping("/{id}")
    public void updateCharacter(@PathVariable String id) {

    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {

    }
}
