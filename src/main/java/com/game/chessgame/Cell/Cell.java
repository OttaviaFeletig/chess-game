package com.game.chessgame.Cell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.chessgame.Board.Board;
import com.game.chessgame.Game.Game;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String letter;
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private Board board;

    public Cell(){}

    public Cell(String letter, String number) {
        this.letter = letter;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @JsonIgnore
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
