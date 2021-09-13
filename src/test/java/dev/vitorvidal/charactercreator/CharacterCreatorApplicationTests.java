package dev.vitorvidal.charactercreator;

import dev.vitorvidal.charactercreator.application.controller.AbilityScoreController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CharacterCreatorApplicationTests {

    @Autowired
    private AbilityScoreController abilityScoreController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(abilityScoreController);
    }

}
