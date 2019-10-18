package com.game.chessgame;

import com.game.chessgame.Game.Game;
import com.game.chessgame.Game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChessController {


    private GameRepository gameRepo;

    @Autowired
    public ChessController(GameRepository gameRepository) {
        this.gameRepo = gameRepository;

    }

    @RequestMapping("/games")
    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }
}
