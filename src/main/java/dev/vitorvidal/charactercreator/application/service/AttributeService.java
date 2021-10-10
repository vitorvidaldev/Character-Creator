package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.domain.model.Attribute;
import dev.vitorvidal.charactercreator.domain.repository.AttributeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;
    private final DiceService diceService;

    public AttributeService(AttributeRepository attributeRepository, DiceService diceService) {
        this.attributeRepository = attributeRepository;
        this.diceService = diceService;
    }

    public List<Attribute> getAll() {
        return attributeRepository.findAll();
    }

    public Attribute setAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    public Attribute getAttribute(String id) {
        Optional<Attribute> byId = attributeRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return byId.get();
    }

    public void deleteAttribute(String id) {
        try {
            attributeRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoSuchElementException("No element with the provided id exists.");
        }
    }

    public Attribute levelUp(String id) {
        Attribute attribute = getAttribute(id);

        attribute.updateStrength(diceService.d3());
        attribute.updateDexterity(diceService.d3());
        attribute.updateConstitution(diceService.d3());
        attribute.updateCharisma(diceService.d3());
        attribute.updateIntelligence(diceService.d3());
        attribute.updateWisdom(diceService.d3());

        attributeRepository.save(attribute);

        return attribute;
    }
}
