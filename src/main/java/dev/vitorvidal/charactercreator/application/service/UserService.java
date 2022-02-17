package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.UserRepository;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserEntity;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserVO> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserVO> userResponseList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userResponseList.add(modelMapper.map(userEntity, UserVO.class));
        }
        return userResponseList;
    }

    public UserVO signup(SignupVO signupVO) {
        UserEntity userEntity = userRepository.save(modelMapper.map(signupVO, UserEntity.class));
        return modelMapper.map(userEntity, UserVO.class);
    }

    public UserVO getUserById(ObjectId id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return modelMapper.map(userEntity, UserVO.class);
        } else {
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public UserVO updateUserData(ObjectId id) {
        // TODO update user data
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return modelMapper.map(userEntity, UserVO.class);
        } else {
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
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
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }

    public void deleteUser(ObjectId id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            userRepository.delete(optionalUserEntity.get());
        } else {
//            log.error("[UserService] Could not find a user with the given id. Id: {}", id);
            throw new NoSuchElementException();
        }
    }
}
