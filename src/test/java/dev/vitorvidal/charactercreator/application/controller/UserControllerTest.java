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

import java.util.List;

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
    void shouldGetAllUsers() {
        UserVO userVoMock = mock(UserVO.class);
        List<UserVO> userListMock = List.of(userVoMock);

        // when
        when(userService.getAllUsers()).thenReturn(userListMock);
        // then
        ResponseEntity<List<UserVO>> allUsers = userController.getAllUsers();
        // assert
        assertNotNull(allUsers);
        assertNotNull(allUsers.getBody());
        assertEquals(HttpStatus.OK, allUsers.getStatusCode());
        assertEquals(userListMock.size(), allUsers.getBody().size());
        assertEquals(userVoMock, allUsers.getBody().get(0));
    }

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
        assertEquals(userMock.id(), signup.getBody().id());
        assertEquals(userMock.username(), signup.getBody().username());
        assertEquals(userMock.email(), signup.getBody().email());
    }

    @Test
    void shouldGetUserById() {
        UserVO userMock = mock(UserVO.class);
        ObjectId idMock = mock(ObjectId.class);

        // when
        when(userService.getUserById(idMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> responseUser = userController.getUserById(idMock);
        // assert
        assertNotNull(responseUser);
        assertNotNull(responseUser.getBody());
        assertEquals(HttpStatus.OK, responseUser.getStatusCode());
        assertEquals(userMock.id(), responseUser.getBody().id());
        assertEquals(userMock.username(), responseUser.getBody().username());
        assertEquals(userMock.email(), responseUser.getBody().email());
    }

    @Test
    void shouldUpdateUserData() {
        UserVO userMock = mock(UserVO.class);
        ObjectId idMock = mock(ObjectId.class);

        // when
        when(userService.updateUserData(idMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> updatedUser = userController.updateUserData(idMock);
        // assert
        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getBody());
        assertEquals(HttpStatus.OK, updatedUser.getStatusCode());
        assertEquals(userMock.id(), updatedUser.getBody().id());
        assertEquals(userMock.username(), updatedUser.getBody().username());
        assertEquals(userMock.email(), updatedUser.getBody().email());
    }

    @Test
    void shouldUpdatePassword() {
        UserVO userMock = mock(UserVO.class);
        ObjectId idMock = mock(ObjectId.class);

        // when
        when(userService.updatePassword(idMock)).thenReturn(userMock);
        // then
        ResponseEntity<UserVO> updatedUser = userController.updatePassword(idMock);
        // assert
        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getBody());
        assertEquals(HttpStatus.OK, updatedUser.getStatusCode());
        assertEquals(userMock.id(), updatedUser.getBody().id());
        assertEquals(userMock.username(), updatedUser.getBody().username());
        assertEquals(userMock.email(), updatedUser.getBody().email());
    }

    @Test
    void shouldDeleteUser() {
        ObjectId idMock = mock(ObjectId.class);

        // when
        doNothing().when(userService).deleteUser(idMock);
        // then
        ResponseEntity<Void> responseObj = userController.deleteUser(idMock);

        assertNotNull(responseObj);
        assertEquals(HttpStatus.NO_CONTENT, responseObj.getStatusCode());
    }
}