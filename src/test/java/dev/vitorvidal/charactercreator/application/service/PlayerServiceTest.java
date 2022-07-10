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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.NoSuchElementException;
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
    @Mock
    private DiceService diceService;
    @InjectMocks
    private PlayerService playerService;

    @Test
    void shouldGetAllPlayers() {
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);
        List<PlayerEntity> playerEntityListMock = List.of(playerEntityMock);
        // when
        when(playerRepository.findAll()).thenReturn(playerEntityListMock);
        // then
        List<PlayerVO> playerList = playerService.getAllPlayers();
        // assert
        assertNotNull(playerList);
        assertEquals(playerEntityListMock.size(), playerList.size());
    }

    @Test
    void shouldCreatePlayer() {
        CreatePlayerVO createPlayerMock = mock(CreatePlayerVO.class);
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);

        // when
        when(playerRepository.save(any())).thenReturn(playerEntityMock);
        // then
        PlayerVO responsePlayer = playerService.createPlayer(createPlayerMock);
        // assert
        assertNotNull(responsePlayer);
        assertThat(responsePlayer).isExactlyInstanceOf(PlayerVO.class);
        assertEquals(playerEntityMock.getPlayerId(), responsePlayer.playerId());
        assertEquals(playerEntityMock.getName(), responsePlayer.name());
        assertEquals(playerEntityMock.getAge(), responsePlayer.age());
    }

    @Test
    void shouldGetPlayerById() {
        UUID playerIdMock = UUID.randomUUID();
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);
        // when
        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.ofNullable(playerEntityMock));
        // then
        PlayerVO playerFound = playerService.getPlayerById(playerIdMock);
        // assert
        assertNotNull(playerFound);
    }

    @Test
    void shouldThrowNoSuchElementExceptionLookingForPlayerById() {
        UUID playerIdMock = UUID.randomUUID();
        // when
        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.empty());
        // then
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> playerService.getPlayerById(playerIdMock));
        // assert
        assertEquals(NoSuchElementException.class, exception.getClass());
    }

    @Test
    void shouldUpdatePlayer() {
        UUID playerIdMock = UUID.randomUUID();
        UpdatePlayerVO updatePlayerMock = mock(UpdatePlayerVO.class);
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);
        // when
        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.ofNullable(playerEntityMock));
        when(playerRepository.save(any())).thenReturn(playerEntityMock);
        // then
        PlayerVO responseObj = playerService.updatePlayer(playerIdMock, updatePlayerMock);
        // assert
        assertNotNull(responseObj);
    }

    @Test
    void shouldThrowNoSuchElementExceptionUpdatingPlayer() {
        UUID playerIdMock = UUID.randomUUID();
        UpdatePlayerVO updatePlayerMock = mock(UpdatePlayerVO.class);
        PlayerEntity playerEntityMock = mock(PlayerEntity.class);
        // when
        when(playerRepository.findById(playerIdMock))
                .thenReturn(Optional.empty());
        when(playerRepository.save(any())).thenReturn(playerEntityMock);
        // then
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> playerService.updatePlayer(playerIdMock, updatePlayerMock)
        );
        // assert
        assertEquals(NoSuchElementException.class, exception.getClass());
    }

    @Test
    void shouldDeletePlayer() {
        UUID playerIdMock = UUID.randomUUID();
        // when
        doNothing().when(playerRepository).deleteById(playerIdMock);
        // then
        // assert
        assertThatCode(() -> playerService.deletePlayer(playerIdMock)).doesNotThrowAnyException();
    }
}