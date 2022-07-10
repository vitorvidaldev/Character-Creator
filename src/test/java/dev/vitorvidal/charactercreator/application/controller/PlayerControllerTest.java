package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerService;
import dev.vitorvidal.charactercreator.model.player.CreatePlayerVO;
import dev.vitorvidal.charactercreator.model.player.PlayerVO;
import dev.vitorvidal.charactercreator.model.player.UpdatePlayerVO;
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
class PlayerControllerTest {
    @Mock
    private PlayerService playerService;
    @InjectMocks
    private PlayerController playerController;

    @Test
    void shouldCreatePlayer() {
        CreatePlayerVO reqBody = mock(CreatePlayerVO.class);
        PlayerVO responseObj = mock(PlayerVO.class);

        // when
        when(playerService.createPlayer(reqBody)).thenReturn(responseObj);
        // then
        ResponseEntity<PlayerVO> createdPlayer = playerController.createPlayer(reqBody);
        // assert
        assertNotNull(createdPlayer);
        assertNotNull(createdPlayer.getBody());
        assertEquals(HttpStatus.CREATED, createdPlayer.getStatusCode());
        assertEquals(responseObj, createdPlayer.getBody());
        assertEquals(responseObj.name(), createdPlayer.getBody().name());
        assertEquals(responseObj.age(), createdPlayer.getBody().age());
    }

    @Test
    void shouldGetPlayerById() {
        UUID playerIdMock = UUID.randomUUID();
        PlayerVO responseMock = mock(PlayerVO.class);

        // when
        when(playerService.getPlayerById(playerIdMock)).thenReturn(responseMock);
        // then
        ResponseEntity<PlayerVO> playerVO = playerController.getPlayerById(playerIdMock);
        // assert
        assertNotNull(playerVO);
        assertNotNull(playerVO.getBody());
        assertEquals(HttpStatus.OK, playerVO.getStatusCode());
        assertEquals(responseMock, playerVO.getBody());
        assertEquals(responseMock.name(), playerVO.getBody().name());
        assertEquals(responseMock.playerId(), playerVO.getBody().playerId());
        assertEquals(responseMock.age(), playerVO.getBody().age());
    }

    @Test
    void shouldUpdatePlayer() {
        UUID playerIdMock = UUID.randomUUID();
        UpdatePlayerVO updatePlayerMock = mock(UpdatePlayerVO.class);
        PlayerVO responseMock = mock(PlayerVO.class);

        // when
        when(playerService.updatePlayer(playerIdMock, updatePlayerMock)).thenReturn(responseMock);
        // then
        ResponseEntity<PlayerVO> updatedPlayer = playerController.updatePlayer(playerIdMock, updatePlayerMock);
        // assert
        assertNotNull(updatedPlayer);
        assertNotNull(updatedPlayer.getBody());
        assertEquals(HttpStatus.OK, updatedPlayer.getStatusCode());
        assertEquals(responseMock.name(), updatedPlayer.getBody().name());
        assertEquals(responseMock.playerId(), updatedPlayer.getBody().playerId());
        assertEquals(responseMock.age(), updatedPlayer.getBody().age());
    }

    @Test
    void shouldDeletePlayer() {
        UUID playerIdMock = UUID.randomUUID();

        // when
        doNothing().when(playerService).deletePlayer(playerIdMock);
        // then
        ResponseEntity<Void> responseObj = playerController.deletePlayer(playerIdMock);
        // assert
        assertNotNull(responseObj);
        assertEquals(HttpStatus.NO_CONTENT, responseObj.getStatusCode());
    }
}