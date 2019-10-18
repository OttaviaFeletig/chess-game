package com.game.chessgame.Game;

import com.game.chessgame.Player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
