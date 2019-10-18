package com.game.chessgame.Board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.chessgame.Cell.Cell;
import com.game.chessgame.Game.Game;
import com.game.chessgame.GamePlayer.GamePlayer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private Set<Cell> cells = new HashSet<>();

    @OneToOne(mappedBy = "board", cascade = CascadeType.ALL)
    private Game game;

    public Board(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @JsonIgnore
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<Cell> getCells() {
        return cells;
    }

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public void addCell(Cell cell){
        cell.setBoard(this);
        cells.add(cell);
    }
}
