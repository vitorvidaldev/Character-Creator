package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.UserRepository;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserEntity;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserVO> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();

        List<UserVO> userResponseList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userResponseList.add(new UserVO(userEntity.getId(),
                    userEntity.getUsername(),
                    userEntity.getEmail()));
        }

        return userResponseList;
    }

    public UserVO signup(SignupVO signupVO) {
        UserEntity userEntity = userRepository.save(
                new UserEntity(signupVO.username(),
                        signupVO.email(),
                        signupVO.password()));

        return new UserVO(userEntity.getId(), userEntity.getUsername(), userEntity.getEmail());
    }

    public UserVO getUserById(ObjectId id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new UserVO(userEntity.getId(), userEntity.getUsername(), userEntity.getEmail());
        } else {
            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public UserVO updateUserData(ObjectId id) {
        // TODO update user data
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new UserVO(userEntity.getId(), userEntity.getUsername(), userEntity.getEmail());
        } else {
            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public UserVO updatePassword(ObjectId id) {
        // TODO update user password
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new UserVO(userEntity.getId(), userEntity.getUsername(), userEntity.getEmail());
        } else {
            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public void deleteUser(ObjectId id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            userRepository.delete(optionalUserEntity.get());
        } else {
            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }
}
