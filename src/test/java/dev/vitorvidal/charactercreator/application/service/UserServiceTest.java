package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.UserRepository;
import dev.vitorvidal.charactercreator.model.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void shouldThrowNotFoundExceptionGettingUserById() {
        UUID userIdMock = UUID.randomUUID();

        when(userRepository.findById(userIdMock)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> userService.getUserById(userIdMock)
        );

        assertNotNull(exception);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("User not found", exception.getReason());

        verify(userRepository).findById(userIdMock);
    }

    @Test
    public void shouldUpdatePasswordCorrectly() {
        UUID userIdMock = UUID.randomUUID();
        String usernameMock = "username";
        String emailMock = "email@gmail.com";

        UpdateUserDataVO updateUserDataVOMock = mock(UpdateUserDataVO.class);
        UserEntity userEntityMock = mock(UserEntity.class);

        when(updateUserDataVOMock.username()).thenReturn(usernameMock);
        when(userEntityMock.getUserId()).thenReturn(userIdMock);
        when(userEntityMock.getUsername()).thenReturn(usernameMock);
        when(userEntityMock.getEmail()).thenReturn(emailMock);

        when(userRepository.findById(userIdMock)).thenReturn(Optional.of(userEntityMock));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntityMock);

        UserVO userVO = userService.updateUserData(userIdMock, updateUserDataVOMock);

        assertNotNull(userVO);
        assertEquals(userIdMock, userVO.userId());
        assertEquals(usernameMock, userVO.username());
        assertEquals(emailMock, userVO.email());

        verify(updateUserDataVOMock).username();
        verify(userEntityMock).getUserId();
        verify(userEntityMock).getUsername();
        verify(userEntityMock).getEmail();

        verify(userRepository).findById(userIdMock);
        verify(userRepository).save(any(UserEntity.class));
    }

    @Test
    public void shouldThrowNotFoundExceptionUpdatingUserData() {
        UUID userIdMock = UUID.randomUUID();
        UpdateUserDataVO updateUserDataVOMock = mock(UpdateUserDataVO.class);

        when(userRepository.findById(userIdMock)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> userService.updateUserData(userIdMock, updateUserDataVOMock)
        );

        assertNotNull(exception);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("User not found", exception.getReason());

        verify(userRepository).findById(userIdMock);
    }

    @Test
    public void shouldUpdateUserDataCorrectly() {
        UUID userIdMock = UUID.randomUUID();
        String usernameMock = "username";
        String passwordMock = "new password";
        String emailMock = "email@gmail.com";

        UpdateUserPasswordVO updateUserPasswordVOMock = mock(UpdateUserPasswordVO.class);
        UserEntity userEntityMock = mock(UserEntity.class);

        when(updateUserPasswordVOMock.password()).thenReturn(passwordMock);
        when(userEntityMock.getUserId()).thenReturn(userIdMock);
        when(userEntityMock.getUsername()).thenReturn(usernameMock);
        when(userEntityMock.getEmail()).thenReturn(emailMock);

        when(userRepository.findById(userIdMock)).thenReturn(Optional.of(userEntityMock));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntityMock);

        UserVO userVO = userService.updatePassword(userIdMock, updateUserPasswordVOMock);

        assertNotNull(userVO);
        assertEquals(userIdMock, userVO.userId());
        assertEquals(usernameMock, userVO.username());
        assertEquals(emailMock, userVO.email());

        verify(updateUserPasswordVOMock).password();
        verify(userEntityMock).getUserId();
        verify(userEntityMock).getUsername();
        verify(userEntityMock).getEmail();

        verify(userRepository).findById(userIdMock);
        verify(userRepository).save(any(UserEntity.class));
    }

    @Test
    public void shouldThrowNotFoundExceptionUpdatingPassword() {
        UUID userIdMock = UUID.randomUUID();
        UpdateUserPasswordVO updateUserPasswordVOMock = mock(UpdateUserPasswordVO.class);

        when(userRepository.findById(userIdMock)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> userService.updatePassword(userIdMock, updateUserPasswordVOMock)
        );

        assertNotNull(exception);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("User not found", exception.getReason());

        verify(userRepository).findById(userIdMock);
    }

    @Test
    public void shouldDeleteUserCorrectly() {
        UUID userIdMock = UUID.randomUUID();
        UserEntity userEntityMock = mock(UserEntity.class);

        when(userRepository.findById(userIdMock)).thenReturn(Optional.of(userEntityMock));
        doNothing().when(userRepository).delete(userEntityMock);

        assertDoesNotThrow(() -> userService.deleteUser(userIdMock));

        verify(userRepository).findById(userIdMock);
        verify(userRepository).delete(userEntityMock);
    }
}