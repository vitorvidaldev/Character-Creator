package dev.vitorvidal.charactercreator.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/diceRoll")
public class DiceRollController {

    static final Random rand = new Random();

    @GetMapping("/d3")
    public int d3() {
        return rand.nextInt(3) + 1;
    }

    @GetMapping("/d4")
    public int d4() {
        return rand.nextInt(4) + 1;
    }

    @GetMapping("/d6")
    public int d6() {
        return rand.nextInt(6) + 1;
    }

    @GetMapping("/d8")
    public int d8() {
        return rand.nextInt(8) + 1;
    }

    @GetMapping("/d10")
    public int d10() {
        return rand.nextInt(10) + 1;
    }

    @GetMapping("/d12")
    public int d12() {
        return rand.nextInt(12) + 1;
    }

    @GetMapping("/d20")
    public int d20() {
        return rand.nextInt(20) + 1;
    }

    @GetMapping("/d100")
    public int d100() {
        return rand.nextInt(100) + 1;
    }
}
