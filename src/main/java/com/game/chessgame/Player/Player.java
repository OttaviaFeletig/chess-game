package com.game.chessgame.Player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.chessgame.GamePlayer.GamePlayer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private String password;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private Set<GamePlayer> gamePlayers = new HashSet<>();

    public Player(){}
    public Player(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGamePlayer(GamePlayer gamePlayer){
        gamePlayer.setPlayer(this);
        gamePlayers.add(gamePlayer);
    }
    @JsonIgnore
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }
}
