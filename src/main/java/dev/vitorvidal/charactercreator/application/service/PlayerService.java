package dev.vitorvidal.charactercreator.application.service;

import dev.vitorvidal.charactercreator.application.repository.PlayerRepository;
import dev.vitorvidal.charactercreator.model.player.*;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final DiceService diceService;

    public PlayerService(
            PlayerRepository playerRepository,
            DiceService diceService) {
        this.playerRepository = playerRepository;
        this.diceService = diceService;
    }

    public List<PlayerVO> getAllPlayers() {
        List<PlayerEntity> playerEntities = playerRepository.findAll();

        List<PlayerVO> playerList = new ArrayList<>();
        for (PlayerEntity playerEntity : playerEntities) {
            playerList.add(new PlayerVO(
                    playerEntity.getId(),
                    playerEntity.getName(),
                    playerEntity.getAge(),
                    playerEntity.getAttribute(),
                    playerEntity.getRace(),
                    playerEntity.getJob()
            ));
        }
        return playerList;
    }

    public PlayerVO createPlayer(CreatePlayerVO createPlayerVO) {
        PlayerEntity savedPlayer = playerRepository.save(new PlayerEntity(
                createPlayerVO.name(),
                createPlayerVO.age()
        ));
        return new PlayerVO(
                savedPlayer.getId(),
                savedPlayer.getName(),
                savedPlayer.getAge(),
                savedPlayer.getAttribute(),
                savedPlayer.getRace(),
                savedPlayer.getJob()
        );
    }

    public PlayerVO getPlayerById(ObjectId id) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) {
            throw new NoSuchElementException();
        }
        return new PlayerVO(
                optionalPlayer.get().getId(),
                optionalPlayer.get().getName(),
                optionalPlayer.get().getAge(),
                optionalPlayer.get().getAttribute(),
                optionalPlayer.get().getRace(),
                optionalPlayer.get().getJob()
        );
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

        return new PlayerVO(
                updatedPlayer.getId(),
                updatedPlayer.getName(),
                updatedPlayer.getAge(),
                updatedPlayer.getAttribute(),
                updatedPlayer.getRace(),
                updatedPlayer.getJob()
        );
    }

    public ResponseEntity<Void> deletePlayer(ObjectId id) {
        playerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Attribute levelUp(String id) {
        Attribute attribute = new Attribute();

        attribute.updateStrength(diceService.d3());
        attribute.updateDexterity(diceService.d3());
        attribute.updateConstitution(diceService.d3());
        attribute.updateCharisma(diceService.d3());
        attribute.updateIntelligence(diceService.d3());
        attribute.updateWisdom(diceService.d3());

        return attribute;
    }
}
