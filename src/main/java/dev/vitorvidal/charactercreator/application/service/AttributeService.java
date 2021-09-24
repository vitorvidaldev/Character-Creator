package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.vo.AbilityScoreVO;
import dev.vitorvidal.charactercreator.domain.model.Attribute;
import dev.vitorvidal.charactercreator.domain.repository.AttributeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public List<Attribute> getAll() {
        return (List<Attribute>) attributeRepository.findAll();
    }

    public AbilityScoreVO setAbilityScore(Attribute attribute) {
        return attributeRepository.save(attribute).toVO();
    }

    public AbilityScoreVO getAbilityScoreById(String id) {
        Optional<Attribute> byId = attributeRepository.findById(UUID.fromString(id));
        if (byId.isEmpty()) {
            throw new NoSuchElementException();
        }
        return byId.get().toVO();
    }

    public void deleteAbilityScore(String id) {
        try {
            attributeRepository.deleteById(UUID.fromString(id));
        } catch (Exception e) {
            throw new NoSuchElementException("No element with the provided id exists.");
        }
    }

    // TODO: Design and implement
    public AbilityScoreVO levelUp() {
        return new AbilityScoreVO();
    }
}
