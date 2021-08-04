package dev.vitorvidal.charactercreator.application.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DiceRollControllerTests {
    private final DiceRollController controller = new DiceRollController();

    @Test
    @DisplayName("Tests if the method returns one of the three possible values for a D3")
    void shouldRollAd3() {
        int d3 = controller.d3();
        List<Integer> results = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        Assertions.assertTrue(results.contains(d3));
    }

    @Test
    @DisplayName("Tests if the method returns one of the four possible values for a D4")
    void shouldRollAd4() {
        int d4 = controller.d4();
        List<Integer> results = IntStream.rangeClosed(1, 4).boxed().collect(Collectors.toList());
        Assertions.assertTrue(results.contains(d4));
    }

    @Test
    @DisplayName("Tests if the method returns one of the six possible values for a D6")
    void shouldRollAd6() {
        int d6 = controller.d6();
        List<Integer> results = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
        Assertions.assertTrue(results.contains(d6));
    }

    @Test
    @DisplayName("Tests if the method returns one of the eight possible values for a D8")
    void shouldRollAd8() {
        int d8 = controller.d8();
        List<Integer> results = IntStream.rangeClosed(1, 8).boxed().collect(Collectors.toList());
        Assertions.assertTrue(results.contains(d8));
    }

    @Test
    @DisplayName("Tests if the method returns one of the ten possible values for a D10")
    void shouldRollAd10() {
        int d10 = controller.d10();
        List<Integer> results = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        Assertions.assertTrue(results.contains(d10));
    }

    @Test
    @DisplayName("Tests if the method returns one of the twelve possible values for a D12")
    void shouldRollAd12() {
        int d12 = controller.d12();
        List<Integer> results = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
        Assertions.assertTrue(results.contains(d12));
    }

    @Test
    @DisplayName("Tests if the method returns one of the twenty possible values for a D20")
    void shouldRollAd20() {
        int d20 = controller.d20();
        List<Integer> results = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
        Assertions.assertTrue(results.contains(d20));
    }
}

