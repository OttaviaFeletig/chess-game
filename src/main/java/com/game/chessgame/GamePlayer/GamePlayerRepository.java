package com.game.chessgame.GamePlayer;

import com.game.chessgame.Player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePlayerRepository extends JpaRepository<GamePlayer, Long> {

}

