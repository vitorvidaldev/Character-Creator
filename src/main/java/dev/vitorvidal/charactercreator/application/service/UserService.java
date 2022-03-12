package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.UserRepository;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserEntity;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public UserVO getUserById(UUID id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new UserVO(
                    userEntity.getUserId(),
                    userEntity.getUsername(),
                    userEntity.getEmail());
        } else {
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public UserVO updateUserData(UUID id) {
        // TODO update user data
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new UserVO(
                    userEntity.getUserId(),
                    userEntity.getUsername(),
                    userEntity.getEmail());
        } else {
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public UserVO updatePassword(UUID id) {
        // TODO update user password
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new UserVO(userEntity.getUserId(), userEntity.getUsername(), userEntity.getEmail());
        } else {
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public void deleteUser(UUID id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            userRepository.delete(optionalUserEntity.get());
        } else {
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }
}
