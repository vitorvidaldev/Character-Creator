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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        PlayerVO playerVO = mock(PlayerVO.class);
        List<PlayerVO> playerList = List.of(playerVO);

        // when
        when(playerService.getAllPlayers()).thenReturn(playerList);
        // then
        ResponseEntity<List<PlayerVO>> responseList = playerController.getAllPlayers();
        // assert
        assertNotNull(responseList);
        assertNotNull(responseList.getBody());
        assertEquals(HttpStatus.OK, responseList.getStatusCode());
        assertEquals(responseList.getBody().size(), playerList.size());
        assertEquals(responseList.getBody().get(0), playerVO);
    }

    @Test
    void createPlayer() {
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
    void getPlayerById() {
    }

    @Test
    void updatePlayer() {
    }

    @Test
    void deletePlayer() {
    }
}