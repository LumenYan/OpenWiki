package com.openwiki.back.service;

import com.openwiki.back.model.Games;
import com.openwiki.back.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Games> getAllGames() {
        return gameRepository.findAll();
    }

    public Games getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Games saveGame(Games game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
