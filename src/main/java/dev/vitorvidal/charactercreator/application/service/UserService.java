package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.UserRepository;
import dev.vitorvidal.charactercreator.model.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public record UserService(UserRepository userRepository) {

    public UserVO signup(SignupVO signupVO) {
        UserEntity userEntity = userRepository.save(new UserEntity(
                signupVO.username(),
                signupVO.email(),
                signupVO.password()));
        return new UserVO(
                userEntity.getUserId(),
                userEntity.getUsername(),
                userEntity.getEmail());
    }

    public UserVO getUserById(UUID userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new UserVO(
                    userEntity.getUserId(),
                    userEntity.getUsername(),
                    userEntity.getEmail());
        } else {
            log.error("[UserService] Could not find a user with the given userId. Id: {}", userId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public UserVO updateUserData(UUID id, UpdateUserDataVO updateUserDataVO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setUsername(updateUserDataVO.username());
            userRepository.save(userEntity);

            return new UserVO(userEntity.getUserId(), userEntity.getUsername(), userEntity.getEmail());
        } else {
            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public UserVO updatePassword(UUID id, UpdateUserPasswordVO updateUserPasswordVO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setPassword(updateUserPasswordVO.password());
            userRepository.save(userEntity);
            return new UserVO(userEntity.getUserId(), userEntity.getUsername(), userEntity.getEmail());
        } else {
            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public void deleteUser(UUID id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            userRepository.delete(optionalUserEntity.get());
        } else {
            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
        }
    }
}
