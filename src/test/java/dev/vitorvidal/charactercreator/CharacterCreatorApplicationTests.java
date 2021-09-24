package dev.vitorvidal.charactercreator;

import dev.vitorvidal.charactercreator.application.controller.AttributeController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CharacterCreatorApplicationTests {

    @Autowired
    private AttributeController attributeController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(attributeController);
    }

}
