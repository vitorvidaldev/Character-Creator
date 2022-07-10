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
        CreatePlayerVO createPlayerVOMock = mock(CreatePlayerVO.class);
        PlayerVO playerVOMock = mock(PlayerVO.class);

        when(playerService.createPlayer(createPlayerVOMock)).thenReturn(playerVOMock);

        ResponseEntity<PlayerVO> response = playerController.createPlayer(createPlayerVOMock);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(playerVOMock, response.getBody());
        assertEquals(playerVOMock.name(), response.getBody().name());
        assertEquals(playerVOMock.age(), response.getBody().age());

        verify(playerService).createPlayer(createPlayerVOMock);
    }

    @Test
    void shouldGetPlayerById() {
        UUID playerIdMock = UUID.randomUUID();
        PlayerVO playerVOMock = mock(PlayerVO.class);

        // when
        when(playerService.getPlayerById(playerIdMock)).thenReturn(playerVOMock);
        // then
        ResponseEntity<PlayerVO> response = playerController.getPlayerById(playerIdMock);
        // assert
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(playerVOMock, response.getBody());
        assertEquals(playerVOMock.name(), response.getBody().name());
        assertEquals(playerVOMock.playerId(), response.getBody().playerId());
        assertEquals(playerVOMock.age(), response.getBody().age());

        verify(playerService).getPlayerById(playerIdMock);
    }

    @Test
    void shouldUpdatePlayer() {
        UUID playerIdMock = UUID.randomUUID();
        UpdatePlayerVO updatePlayerVOMock = mock(UpdatePlayerVO.class);
        PlayerVO playerVOMock = mock(PlayerVO.class);

        // when
        when(playerService.updatePlayer(playerIdMock, updatePlayerVOMock)).thenReturn(playerVOMock);
        // then
        ResponseEntity<PlayerVO> response = playerController.updatePlayer(playerIdMock, updatePlayerVOMock);
        // assert
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(playerVOMock.name(), response.getBody().name());
        assertEquals(playerVOMock.playerId(), response.getBody().playerId());
        assertEquals(playerVOMock.age(), response.getBody().age());

        verify(playerService).updatePlayer(playerIdMock, updatePlayerVOMock);
    }

    @Test
    void shouldDeletePlayer() {
        UUID playerIdMock = UUID.randomUUID();

        // when
        doNothing().when(playerService).deletePlayer(playerIdMock);
        // then
        ResponseEntity<Void> response = playerController.deletePlayer(playerIdMock);
        // assert
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(playerService).deletePlayer(playerIdMock);
    }
}