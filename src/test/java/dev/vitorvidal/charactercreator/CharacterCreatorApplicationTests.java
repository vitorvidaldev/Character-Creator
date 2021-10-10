package dev.vitorvidal.charactercreator;

import dev.vitorvidal.charactercreator.application.controller.PlayerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CharacterCreatorApplicationTests {

    @Autowired
    private PlayerController playerController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(playerController);
    }

}
