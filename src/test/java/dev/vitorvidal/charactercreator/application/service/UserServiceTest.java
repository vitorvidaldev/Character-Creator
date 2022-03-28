package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.UserRepository;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserEntity;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void shouldSignupCorrectly() {
        UserEntity userEntityMock = new UserEntity("test", "test@test.com", "password");
        userEntityMock.setUserId(UUID.randomUUID());
        SignupVO signupMock = new SignupVO("test", "test@test.com", "password");

        // when
        when(userRepository.save(new UserEntity(signupMock.username(), signupMock.email(), signupMock.password()))).thenReturn(userEntityMock);
        // then
        UserVO newUser = userService.signup(signupMock);
        // assert
        assertNotNull(newUser);
        assertEquals(UserVO.class, newUser.getClass());
    }
}