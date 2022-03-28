package dev.vitorvidal.charactercreator.application.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceServiceTest {
    private final DiceService dice = new DiceService();

    @Test
    @DisplayName("Returns one of the three possible values for a D3")
    void shouldRollAd3() {
        int d3 = dice.d3();
        List<Integer> results = IntStream.rangeClosed(1, 3).boxed().toList();
        assertTrue(results.contains(d3));
        assertTrue(d3 > 0);
        assertTrue(d3 <= 3);
    }

    @Test
    @DisplayName("Returns one of the four possible values for a D4")
    void shouldRollAd4() {
        int d4 = dice.d4();
        List<Integer> results = IntStream.rangeClosed(1, 4).boxed().toList();
        assertTrue(results.contains(d4));
        assertTrue(d4 > 0);
        assertTrue(d4 <= 4);
    }

    @Test
    @DisplayName("Returns one of the six possible values for a D6")
    void shouldRollAd6() {
        int d6 = dice.d6();
        List<Integer> results = IntStream.rangeClosed(1, 6).boxed().toList();
        assertTrue(results.contains(d6));
        assertTrue(d6 > 0);
        assertTrue(d6 <= 6);
    }

    @Test
    @DisplayName("Returns one of the eight possible values for a D8")
    void shouldRollAd8() {
        int d8 = dice.d8();
        List<Integer> results = IntStream.rangeClosed(1, 8).boxed().toList();
        assertTrue(results.contains(d8));
        assertTrue(d8 > 0);
        assertTrue(d8 <= 8);
    }

    @Test
    @DisplayName("Returns one of the ten possible values for a D10")
    void shouldRollAd10() {
        int d10 = dice.d10();
        List<Integer> results = IntStream.rangeClosed(1, 10).boxed().toList();
        assertTrue(results.contains(d10));
        assertTrue(d10 > 0);
        assertTrue(d10 <= 10);
    }

    @Test
    @DisplayName("Returns one of the twelve possible values for a D12")
    void shouldRollAd12() {
        int d12 = dice.d12();
        List<Integer> results = IntStream.rangeClosed(1, 12).boxed().toList();
        assertTrue(results.contains(d12));
        assertTrue(d12 > 0);
        assertTrue(d12 <= 12);
    }

    @Test
    @DisplayName("Returns one of the twenty possible values for a D20")
    void shouldRollAd20() {
        int d20 = dice.d20();
        List<Integer> results = IntStream.rangeClosed(1, 20).boxed().toList();
        assertTrue(results.contains(d20));
        assertTrue(d20 > 0);
        assertTrue(d20 <= 20);
    }

    @Test
    @DisplayName("Returns one of the twenty possible values for a D20")
    void shouldRollAd100() {
        int d100 = dice.d100();
        List<Integer> results = IntStream.rangeClosed(1, 100).boxed().toList();
        assertTrue(results.contains(d100));
        assertTrue(d100 > 0);
        assertTrue(d100 <= 100);
    }
}
