package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.UserService;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.bson.types.ObjectId;
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
        assertEquals(userMock.getId(), signup.getBody().getId());
        assertEquals(userMock.getUsername(), signup.getBody().getUsername());
        assertEquals(userMock.getEmail(), signup.getBody().getEmail());
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
        assertEquals(userMock.getId(), responseUser.getBody().getId());
        assertEquals(userMock.getUsername(), responseUser.getBody().getUsername());
        assertEquals(userMock.getEmail(), responseUser.getBody().getEmail());
    }

    @Test
    void shouldUpdateUserData() {
        UserVO userMock = mock(UserVO.class);
        UUID userIdMock = UUID.randomUUID();

        // when
        when(userService.updateUserData(userIdMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> updatedUser = userController.updateUserData(userIdMock);
        // assert
        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getBody());
        assertEquals(HttpStatus.OK, updatedUser.getStatusCode());
        assertEquals(userMock.getId(), updatedUser.getBody().getId());
        assertEquals(userMock.getUsername(), updatedUser.getBody().getUsername());
        assertEquals(userMock.getEmail(), updatedUser.getBody().getEmail());
    }

    @Test
    void shouldUpdatePassword() {
        UserVO userMock = mock(UserVO.class);
        UUID userIdMock = UUID.randomUUID();

        // when
        when(userService.updatePassword(userIdMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> updatedUser = userController.updatePassword(userIdMock);
        // assert
        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getBody());
        assertEquals(HttpStatus.OK, updatedUser.getStatusCode());
        assertEquals(userMock.getId(), updatedUser.getBody().getId());
        assertEquals(userMock.getUsername(), updatedUser.getBody().getUsername());
        assertEquals(userMock.getEmail(), updatedUser.getBody().getEmail());
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