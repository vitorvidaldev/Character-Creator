package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.PlayerService;
import dev.vitorvidal.charactercreator.model.player.CreatePlayerVO;
import dev.vitorvidal.charactercreator.model.player.PlayerVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PlayerControllerTest {
    @Mock
    private PlayerService playerService;
    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllPlayers() {
    }

    @Test
    void createPlayer() {
        CreatePlayerVO createPlayerMock = mock(CreatePlayerVO.class);
        PlayerVO playerVoMock = mock(PlayerVO.class);

        // when
        when(playerService.createPlayer(createPlayerMock)).thenReturn(playerVoMock);
        // then
        ResponseEntity<PlayerVO> player = playerController.createPlayer(createPlayerMock);
        // assert
        assertEquals(HttpStatus.CREATED, player.getStatusCode());
        assertEquals(playerVoMock, player.getBody());
    }

    @Test
    void getPlayerById() {
    }

    @Test
    void updatePlayer() {
    }

    @Test
    void deletePlayer() {
    }
}