package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.charactercreator.domain.model.AbilityScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@Disabled
class AttributeServiceTest {

    private static final List<AbilityScore> abilityScores = new ArrayList<>();
    private static AbilityScore abilityScore;
    private static AttributeService serviceMock;

    @BeforeAll
    public static void setupMock() {
        abilityScore = new AbilityScore(10, 10, 10, 10, 10, 10);
        abilityScores.add(abilityScore);
        abilityScores.add(abilityScore);

        serviceMock = Mockito.mock(AttributeService.class);
    }

    @Test
    void testVariableAllocation() {
        Assertions.assertNotNull(abilityScore);
        Assertions.assertNotNull(abilityScores);
        Assertions.assertNotNull(serviceMock);
    }

    @Test
    void testGetAllStatusCode() {
        Mockito.when(serviceMock.getAll()).thenReturn(abilityScores);
        List<AbilityScore> returnObject = serviceMock.getAll();
        Assertions.assertEquals(abilityScores, returnObject);
    }

    @Test
    void testSetAbilityScore() {
        Mockito.when(serviceMock.setAbilityScore(abilityScore)).thenReturn(abilityScore.toVO());
        AbilityScoreVO returnObject = serviceMock.setAbilityScore(abilityScore);
        Assertions.assertEquals(abilityScore.toVO(), returnObject);
    }

    @Test
    void testGetAbilityScoreById() {
        Mockito.when(serviceMock.getAbilityScoreById(abilityScore.getId().toString())).thenReturn(abilityScore.toVO());
        AbilityScoreVO returnObject = serviceMock.getAbilityScoreById(abilityScore.getId().toString());
        Assertions.assertEquals(abilityScore.toVO(), returnObject);
    }

    @Test
    @Disabled("Not Implemented")
    void testDeleteAbilityScore() {
        // TODO How to test a method that returns void?
    }

    @Test
    @Disabled("Not Implemented")
    void testLevelUp() {
    }
}