package dev.vitorvidal.charactercreator.application.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceService {
    // TODO Implement better random number generator
    static final Random rand = new Random();

    public int d3() {
        return rand.nextInt(3) + 1;
    }

    public int d4() {
        return rand.nextInt(4) + 1;
    }

    public int d6() {
        return rand.nextInt(6) + 1;
    }

    public int d8() {
        return rand.nextInt(8) + 1;
    }

    public int d10() {
        return rand.nextInt(10) + 1;
    }

    public int d12() {
        return rand.nextInt(12) + 1;
    }

    public int d20() {
        return rand.nextInt(20) + 1;
    }

    public int d100() {
        return rand.nextInt(100) + 1;
    }
}
