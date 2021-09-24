package dev.vitorvidal.charactercreator.domain.repository;

import dev.vitorvidal.charactercreator.domain.model.Attribute;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

//@Repository
public interface AttributeRepository extends MongoRepository<Attribute, UUID> {
}
