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

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    public void shouldSignupCorrectly() {
        String usernameMock = "username";
        String emailMock = "email@gmail.com";
        String passwordMock = "password";
        UUID userIdMock = UUID.randomUUID();

        SignupVO signupVOMock = mock(SignupVO.class);
        UserEntity userEntityMock = mock(UserEntity.class);

        when(signupVOMock.username()).thenReturn(usernameMock);
        when(signupVOMock.email()).thenReturn(emailMock);
        when(signupVOMock.password()).thenReturn(passwordMock);

        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntityMock);

        when(userEntityMock.getUserId()).thenReturn(userIdMock);
        when(userEntityMock.getEmail()).thenReturn(emailMock);
        when(userEntityMock.getUsername()).thenReturn(usernameMock);
        when(userEntityMock.getPassword()).thenReturn(passwordMock);

        UserVO userVO = userService.signup(signupVOMock);

        assertNotNull(userVO);
        assertEquals(usernameMock, userVO.username());
        assertEquals(userIdMock, userVO.userId());
        assertEquals(emailMock, userVO.email());

        verify(signupVOMock).email();
        verify(signupVOMock).password();
        verify(signupVOMock).username();

        verify(userEntityMock).getUserId();
        verify(userEntityMock).getEmail();
        verify(userEntityMock).getUsername();

        verify(userRepository).save(any(UserEntity.class));
    }

    @Test
    public void shouldGetUserByIdCorrectly() {
        UUID userIdMock = UUID.randomUUID();
        String usernameMock = "username";
        String emailMock = "test@gmail.com";

        UserEntity userEntityMock = mock(UserEntity.class);

        when(userRepository.findById(userIdMock)).thenReturn(Optional.of(userEntityMock));

        when(userEntityMock.getUserId()).thenReturn(userIdMock);
        when(userEntityMock.getUsername()).thenReturn(usernameMock);
        when(userEntityMock.getEmail()).thenReturn(emailMock);

        UserVO userVO = userService.getUserById(userIdMock);

        assertNotNull(userVO);
        assertEquals(userIdMock, userVO.userId());
        assertEquals(emailMock, userVO.email());
        assertEquals(usernameMock, userVO.username());

        verify(userRepository).findById(userIdMock);

        verify(userEntityMock).getUserId();
        verify(userEntityMock).getUsername();
        verify(userEntityMock).getEmail();
    }
}