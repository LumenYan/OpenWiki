package com.openwiki.back.controller;

import com.openwiki.back.model.Games;
import com.openwiki.back.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Games> getAllGames() {
        List<Games> games = gameService.getAllGames(); // 获取所有游戏数据

        // 打印每个游戏的详细信息
        for (Games game : games) {
            System.out.println(game.toString()); // 需要在Games类中重写toString方法
        }

        return games; // 返回游戏数据
    }

    @GetMapping("/{id}")
    public Games getGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @PostMapping
    public Games createGame(@RequestBody Games game) {
        return gameService.saveGame(game);
    }

    @PutMapping("/{id}")
    public Games updateGame(@PathVariable Long id, @RequestBody Games game) {
        //game.setId(id);
        return gameService.saveGame(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
