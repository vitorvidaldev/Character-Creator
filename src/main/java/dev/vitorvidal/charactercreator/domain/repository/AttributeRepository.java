package dev.vitorvidal.charactercreator.domain.repository;

import dev.vitorvidal.charactercreator.domain.model.Attribute;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends MongoRepository<Attribute, String> {
}
