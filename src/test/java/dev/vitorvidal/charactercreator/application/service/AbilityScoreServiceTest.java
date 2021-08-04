package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AbilityScoreServiceTest {

    private static final AbilityScore abilityScore = new AbilityScore(10, 10, 10, 10, 10, 10);
    private static AbilityScoreService serviceMock;

    @BeforeAll
    public static void setupMock() {
        serviceMock = Mockito.mock(AbilityScoreService.class);
    }

    @Test
    void testVariableAllocation() {
        Assertions.assertNotNull(abilityScore);
        Assertions.assertNotNull(serviceMock);
    }

    @Test
    void testGetAllStatusCode() {
        AbilityScoreService serviceMock = Mockito.mock(AbilityScoreService.class);
    }

    @Test
    @Disabled("Not Implemented")
    void testSetAbilityScore() {

    }

    @Test
    @Disabled("Not Implemented")
    void testGetAbilityScoreById() {
    }

    @Test
    @Disabled("Not Implemented")
    void testDeleteAbilityScore() {
    }

    @Test
    @Disabled("Not Implemented")
    void testLevelUp() {
    }
}