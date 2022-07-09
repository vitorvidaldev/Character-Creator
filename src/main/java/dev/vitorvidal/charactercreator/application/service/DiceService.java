package dev.vitorvidal.charactercreator.application.service;

import org.springframework.stereotype.Service;

@Service
public record DiceService() {
    private int PRNG(int ceil) {
        return (((ceil - 1) * 13) + 3) % 7;
    }

    public int d3() {
        return PRNG(3) + 1;
    }

    public int d4() {
        return PRNG(4) + 1;
    }

    public int d6() {
        return PRNG(6) + 1;
    }

    public int d8() {
        return PRNG(8) + 1;
    }

    public int d10() {
        return PRNG(10) + 1;
    }

    public int d12() {
        return PRNG(12) + 1;
    }

    public int d20() {
        return PRNG(20) + 1;
    }

    public int d100() {
        return PRNG(100) + 1;
    }
}
