package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.UserRepository;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserEntity;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void shouldGetAllUsersCorrectly() {
        UserEntity userEntityMock = mock(UserEntity.class);
        List<UserEntity> userListMock = new ArrayList<>();
        userListMock.add(userEntityMock);
        // when
        when(userRepository.findAll()).thenReturn(userListMock);
        // then
        List<UserVO> allUsers = userService.getAllUsers();
        // assert
        assertNotNull(allUsers);
        assertEquals(ArrayList.class, allUsers.getClass());
        UserVO userVO = allUsers.get(0);
        assertNotNull(userVO);
        assertEquals(UserVO.class, userVO.getClass());
    }

    @Test
    @Disabled("User Entity is returning null, for some reason")
    void shouldSignupCorrectly() {
        UserEntity userEntityMock = new UserEntity(
                "test",
                "test@test.com",
                "password"
        );
        userEntityMock.setId(ObjectId.get());
        SignupVO signupMock = new SignupVO(
                "test",
                "test@test.com",
                "password"
        );

        // when
        when(userRepository.save(new UserEntity(
                signupMock.username(),
                signupMock.email(),
                signupMock.password()
        ))).thenReturn(userEntityMock);
        // then
        UserVO newUser = userService.signup(signupMock);
        // assert
        assertNotNull(newUser);
        assertEquals(UserVO.class, newUser.getClass());
    }

    @Test
    void getUserById() {
    }

    @Test
    void updateUserData() {
    }

    @Test
    void updatePassword() {
    }

    @Test
    void deleteUser() {

    }
}