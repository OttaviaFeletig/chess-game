package com.game.chessgame;

import com.game.chessgame.Game.Game;
import com.game.chessgame.Game.GameRepository;
import com.game.chessgame.GamePlayer.GamePlayer;
import com.game.chessgame.GamePlayer.GamePlayerRepository;
import com.game.chessgame.Player.Player;
import com.game.chessgame.Player.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChessGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessGameApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepo, GameRepository gameRepo, GamePlayerRepository gamePlayerRepo) {
		return (args) -> {
			// save a couple of customers
			Player player1 = new Player("Jack", "24");
			Player player2 = new Player("Kim", "48");

			Game game1 = new Game();

			GamePlayer gamePlayer1 = new GamePlayer();
			GamePlayer gamePlayer2 = new GamePlayer();

			gamePlayer1.setPlayer(player1);
			gamePlayer1.setGame(game1);
			gamePlayer2.setPlayer(player2);
			gamePlayer2.setGame(game1);

			playerRepo.save(player1);
			playerRepo.save(player2);

			gameRepo.save(game1);

			gamePlayerRepo.save(gamePlayer1);
			gamePlayerRepo.save(gamePlayer2);

		};
	}
}
