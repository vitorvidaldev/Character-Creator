package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.PlayerRepository;
import dev.vitorvidal.charactercreator.model.player.CreatePlayerVO;
import dev.vitorvidal.charactercreator.model.player.PlayerEntity;
import dev.vitorvidal.charactercreator.model.player.PlayerVO;
import dev.vitorvidal.charactercreator.model.player.UpdatePlayerVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PlayerServiceTest {
    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private PlayerService playerService;

    @Test
    void shouldGetAllPlayers() {
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);

        when(playerRepository.findAll()).thenReturn(List.of(playerEntityMock));

        List<PlayerVO> playerList = playerService.getAllPlayers();

        assertNotNull(playerList);
        assertEquals(playerEntityMock.getPlayerId(), playerList.get(0).playerId());

        verify(playerRepository).findAll();
    }

    @Test
    void shouldCreatePlayer() {
        CreatePlayerVO createPlayerMock = mock(CreatePlayerVO.class);
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);

        when(playerRepository.save(any())).thenReturn(playerEntityMock);

        PlayerVO responsePlayer = playerService.createPlayer(createPlayerMock);

        assertNotNull(responsePlayer);
        assertThat(responsePlayer).isExactlyInstanceOf(PlayerVO.class);
        assertEquals(playerEntityMock.getPlayerId(), responsePlayer.playerId());
        assertEquals(playerEntityMock.getName(), responsePlayer.name());
        assertEquals(playerEntityMock.getAge(), responsePlayer.age());

        verify(playerRepository).save(any());
    }

    @Test
    void shouldGetPlayerById() {
        UUID playerIdMock = UUID.randomUUID();
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);

        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.ofNullable(playerEntityMock));

        PlayerVO playerFound = playerService.getPlayerById(playerIdMock);

        assertNotNull(playerFound);

        verify(playerRepository).findById(playerIdMock);
    }

    @Test
    void shouldThrowNoSuchElementExceptionLookingForPlayerById() {
        UUID playerIdMock = UUID.randomUUID();

        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> playerService.getPlayerById(playerIdMock));

        assertNotNull(exception);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("Player not found", exception.getReason());

        verify(playerRepository).findById(playerIdMock);
    }

    @Test
    void shouldUpdatePlayer() {
        UUID playerIdMock = UUID.randomUUID();
        UpdatePlayerVO updatePlayerMock = mock(UpdatePlayerVO.class);
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);

        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.ofNullable(playerEntityMock));
        when(playerRepository.save(any())).thenReturn(playerEntityMock);

        PlayerVO playerVO = playerService.updatePlayer(playerIdMock, updatePlayerMock);

        assertNotNull(playerVO);

        verify(playerRepository).findById(playerIdMock);
        verify(playerRepository).save(any());
    }

    @Test
    void shouldThrowNoSuchElementExceptionUpdatingPlayer() {
        UUID playerIdMock = UUID.randomUUID();
        UpdatePlayerVO updatePlayerMock = mock(UpdatePlayerVO.class);

        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> playerService.updatePlayer(playerIdMock, updatePlayerMock)
        );

        assertNotNull(exception);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("Player not found", exception.getReason());

        verify(playerRepository).findById(playerIdMock);
    }

    @Test
    void shouldDeletePlayer() {
        UUID playerIdMock = UUID.randomUUID();

        doNothing().when(playerRepository).deleteById(playerIdMock);

        assertThatCode(() -> playerService.deletePlayer(playerIdMock)).doesNotThrowAnyException();

        verify(playerRepository).deleteById(playerIdMock);
    }
}