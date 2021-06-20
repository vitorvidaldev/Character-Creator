package dev.vitorvidal.characterCreator.application.vo;

import dev.vitorvidal.characterCreator.domain.model.AbilityScore;

import java.util.UUID;

public class AbilityScoreVO {

    private UUID id;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public AbilityScoreVO(AbilityScore abilityScore) {
        AbilityScoreVO vo = new AbilityScoreVO();
        vo.id = abilityScore.getId();
        vo.strength = abilityScore.getStrength();
        vo.dexterity = abilityScore.getDexterity();
        vo.constitution = abilityScore.getConstitution();
        vo.intelligence = abilityScore.getConstitution();
        vo.wisdom = abilityScore.getWisdom();
        vo.charisma = abilityScore.getCharisma();
    }

    public AbilityScoreVO() {
    }

    @Override
    public String toString() {
        return "AbilityScoreVO{" +
                "id=" + id +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                '}';
    }
}
