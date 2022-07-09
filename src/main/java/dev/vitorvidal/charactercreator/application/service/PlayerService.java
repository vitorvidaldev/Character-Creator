package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.PlayerRepository;
import dev.vitorvidal.charactercreator.model.player.*;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public record PlayerService(PlayerRepository playerRepository, DiceService diceService) {
    private static final ModelMapper modelMapper = new ModelMapper();

    public List<PlayerVO> getAllPlayers() {
        List<PlayerEntity> playerEntities = playerRepository.findAll();

        List<PlayerVO> playerList = new ArrayList<>();
        for (PlayerEntity playerEntity : playerEntities) {
            playerList.add(modelMapper.map(playerEntity, PlayerVO.class));
        }
        return playerList;
    }

    public PlayerVO createPlayer(CreatePlayerVO createPlayerVO) {
        PlayerEntity savedPlayer = playerRepository.save(modelMapper.map(createPlayerVO, PlayerEntity.class));
        return modelMapper.map(savedPlayer, PlayerVO.class);
    }

    public PlayerVO getPlayerById(ObjectId id) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) {
            throw new NoSuchElementException();
        }
        return modelMapper.map(optionalPlayer.get(), PlayerVO.class);
    }

    public PlayerVO updatePlayer(ObjectId id, UpdatePlayerVO updatePlayerVO) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) {
            throw new NoSuchElementException();
        }

        optionalPlayer.get().setName(updatePlayerVO.name());
        optionalPlayer.get().setAge(updatePlayerVO.age());
        optionalPlayer.get().setRace(updatePlayerVO.race());
        optionalPlayer.get().setJob(updatePlayerVO.job());
        PlayerEntity updatedPlayer = playerRepository.save(optionalPlayer.get());

        return modelMapper.map(updatedPlayer, PlayerVO.class);
    }

    public void deletePlayer(ObjectId id) {
        playerRepository.deleteById(id);
    }

    public AttributeVO levelUp(String playerId) {
        // TODO
        return null;
    }
}
