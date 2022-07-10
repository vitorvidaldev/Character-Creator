package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.PlayerRepository;
import dev.vitorvidal.charactercreator.model.player.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public record PlayerService(PlayerRepository playerRepository, DiceService diceService) {

    public List<PlayerVO> getAllPlayers() {
        List<PlayerEntity> playerEntities = playerRepository.findAll();

        List<PlayerVO> playerList = new ArrayList<>();
        for (PlayerEntity playerEntity : playerEntities) {
            playerList.add(
                    new PlayerVO(
                            playerEntity.getPlayerId(),
                            playerEntity.getName(),
                            playerEntity.getAge(),
                            playerEntity.getAttributes(),
                            playerEntity.getRace(),
                            playerEntity.getJob()
                    )
            );
        }
        return playerList;
    }

    public PlayerVO createPlayer(CreatePlayerVO createPlayerVO) {
        PlayerEntity savedPlayer = playerRepository.save(new PlayerEntity(
                createPlayerVO.name(),
                createPlayerVO.age(),
                createPlayerVO.attributes(),
                createPlayerVO.race(),
                createPlayerVO.job()
        ));
        return new PlayerVO(
                savedPlayer.getPlayerId(),
                savedPlayer.getName(),
                savedPlayer.getAge(),
                savedPlayer.getAttributes(),
                savedPlayer.getRace(),
                savedPlayer.getJob()
        );
    }

    public PlayerVO getPlayerById(UUID playerId) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
        }
        return new PlayerVO(
                optionalPlayer.get().getPlayerId(),
                optionalPlayer.get().getName(),
                optionalPlayer.get().getAge(),
                optionalPlayer.get().getAttributes(),
                optionalPlayer.get().getRace(),
                optionalPlayer.get().getJob()
        );
    }

    public PlayerVO updatePlayer(UUID playerId, UpdatePlayerVO updatePlayerVO) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
        }

        optionalPlayer.get().setName(updatePlayerVO.name());
        optionalPlayer.get().setAge(updatePlayerVO.age());
        optionalPlayer.get().setRace(updatePlayerVO.race());
        optionalPlayer.get().setJob(updatePlayerVO.job());
        PlayerEntity savedEntity = playerRepository.save(optionalPlayer.get());

        return new PlayerVO(
                savedEntity.getPlayerId(),
                savedEntity.getName(),
                savedEntity.getAge(),
                savedEntity.getAttributes(),
                savedEntity.getRace(),
                savedEntity.getJob()
        );
    }

    public void deletePlayer(UUID playerId) {
        playerRepository.deleteById(playerId);
    }

    public AttributeVO levelUp(String playerId) {
        // TODO
        return null;
    }
}
