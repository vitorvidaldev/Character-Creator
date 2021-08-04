package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class AbilityScoreServiceTest {

    private static AbilityScore abilityScore;

    @BeforeAll
    public static void setupMock() {
        abilityScore = Mockito.mock(AbilityScore.class);
    }

    @Test
    void testsMocks() {
        Assertions.assertNotNull(abilityScore);
    }

    @Test
    void testGetAllStatusCode() {
        AbilityScoreService serviceMock = Mockito.mock(AbilityScoreService.class);
        Mockito.when(serviceMock.getAll()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        Assertions.assertEquals(HttpStatus.OK, serviceMock.getAll().getStatusCode());
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