package com.game.chessgame;

import com.game.chessgame.Board.Board;
import com.game.chessgame.Board.BoardRepository;
import com.game.chessgame.Cell.Cell;
import com.game.chessgame.Cell.CellRepository;
import com.game.chessgame.Game.Game;
import com.game.chessgame.Game.GameRepository;
import com.game.chessgame.GamePlayer.GamePlayer;
import com.game.chessgame.GamePlayer.GamePlayerRepository;
import com.game.chessgame.Piece.Piece;
import com.game.chessgame.Piece.PieceRepository;
import com.game.chessgame.Piece.Pieces.King;
import com.game.chessgame.Player.Player;
import com.game.chessgame.Player.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ChessGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessGameApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepo, GameRepository gameRepo, GamePlayerRepository gamePlayerRepo, BoardRepository boardRepo, CellRepository cellRepo, PieceRepository pieceRepo) {
		return (args) -> {
			// save a couple of customers
			Player player1 = new Player("Jack", "24");
			Player player2 = new Player("Kim", "48");

			Game game1 = new Game();

			GamePlayer gamePlayer1 = new GamePlayer();
			GamePlayer gamePlayer2 = new GamePlayer();

			gamePlayer1.setPlayer(player1);
			gamePlayer2.setPlayer(player2);
			game1.addGamePlayer(gamePlayer1);
			game1.addGamePlayer(gamePlayer2);
			Board board1 = new Board();

			String[] cellLetters = {"A", "B", "C", "D", "E", "F", "G", "H"};
			String[] cellNumbers = {"1", "2", "3", "4", "5", "6", "7", "8"};
			boardRepo.save(board1);

			for (int i = 0; i < cellLetters.length; i++){
				for(int g = 0; g < cellNumbers.length; g++){
					Cell cell = new Cell(cellLetters[i], cellNumbers[g]);
					board1.addCell(cell);
					cellRepo.save(cell);
				}
			}

			King king = new King();

			gamePlayer1.addPiece(king);


			game1.setBoard(board1);
			playerRepo.save(player1);
			playerRepo.save(player2);

			gameRepo.save(game1);

			gamePlayerRepo.save(gamePlayer1);
			gamePlayerRepo.save(gamePlayer2);
            pieceRepo.save(king);
		};
	}
}
