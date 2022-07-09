package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.UserService;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UpdateUserDataVO;
import dev.vitorvidal.charactercreator.model.user.UpdateUserPasswordVO;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    void shouldSignup() {
        UserVO userMock = mock(UserVO.class);
        SignupVO signupMock = mock(SignupVO.class);

        // when
        when(userService.signup(signupMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> signup = userController.signup(signupMock);
        // assert
        assertNotNull(signup);
        assertNotNull(signup.getBody());
        assertEquals(HttpStatus.CREATED, signup.getStatusCode());
        assertEquals(userMock.userId(), signup.getBody().userId());
        assertEquals(userMock.username(), signup.getBody().username());
        assertEquals(userMock.email(), signup.getBody().email());
    }

    @Test
    void shouldGetUserById() {
        UserVO userMock = mock(UserVO.class);
        UUID userIdMock = UUID.randomUUID();

        // when
        when(userService.getUserById(userIdMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> responseUser = userController.getUserById(userIdMock);
        // assert
        assertNotNull(responseUser);
        assertNotNull(responseUser.getBody());
        assertEquals(HttpStatus.OK, responseUser.getStatusCode());
        assertEquals(userMock.userId(), responseUser.getBody().userId());
        assertEquals(userMock.username(), responseUser.getBody().username());
        assertEquals(userMock.email(), responseUser.getBody().email());
    }

    @Test
    void shouldUpdateUserData() {
        UserVO userMock = mock(UserVO.class);
        UpdateUserDataVO updateUserDataVOMock = mock(UpdateUserDataVO.class);
        UUID userIdMock = UUID.randomUUID();

        // when
        when(userService.updateUserData(userIdMock, updateUserDataVOMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> updatedUser = userController.updateUserData(userIdMock, updateUserDataVOMock);
        // assert
        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getBody());
        assertEquals(HttpStatus.OK, updatedUser.getStatusCode());
        assertEquals(userMock.userId(), updatedUser.getBody().userId());
        assertEquals(userMock.username(), updatedUser.getBody().username());
        assertEquals(userMock.email(), updatedUser.getBody().email());
    }

    @Test
    void shouldUpdatePassword() {
        UserVO userMock = mock(UserVO.class);
        UpdateUserPasswordVO updateUserPasswordVOMock = mock(UpdateUserPasswordVO.class);
        UUID userIdMock = UUID.randomUUID();

        // when
        when(userService.updatePassword(userIdMock, updateUserPasswordVOMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> updatedUser = userController.updatePassword(userIdMock, updateUserPasswordVOMock);
        // assert
        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getBody());
        assertEquals(HttpStatus.OK, updatedUser.getStatusCode());
        assertEquals(userMock.userId(), updatedUser.getBody().userId());
        assertEquals(userMock.username(), updatedUser.getBody().username());
        assertEquals(userMock.email(), updatedUser.getBody().email());
    }

    @Test
    void shouldDeleteUser() {
        UUID userIdMock = UUID.randomUUID();

        // when
        doNothing().when(userService).deleteUser(userIdMock);
        // then
        ResponseEntity<Void> responseObj = userController.deleteUser(userIdMock);

        assertNotNull(responseObj);
        assertEquals(HttpStatus.NO_CONTENT, responseObj.getStatusCode());
    }
}