package dev.vitorvidal.charactercreator.application.repository;

import dev.vitorvidal.charactercreator.model.user.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, UUID> {
}
