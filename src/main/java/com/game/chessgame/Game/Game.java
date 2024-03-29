package com.game.chessgame.Game;

import com.game.chessgame.Board.Board;
import com.game.chessgame.GamePlayer.GamePlayer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<GamePlayer> gamePlayers = new HashSet<>();


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private Board board;

    public Game(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void addGamePlayer(GamePlayer gamePlayer){
        gamePlayer.setGame(this);
        gamePlayers.add(gamePlayer);
    }
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
