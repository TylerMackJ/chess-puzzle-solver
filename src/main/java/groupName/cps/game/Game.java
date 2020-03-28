package groupName.cps.game;

import java.util.Arrays;

public class Game {
    public Piece[][] board;
    public State state;

    public Game(Piece[][] clone, State state) {
        this.board = new Piece[8][8];
        for(int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if(clone[y][x] == null) {
                    this.board[y][x] = null;
                } else {
                    this.board[y][x] = new Piece(clone[y][x].type, clone[y][x].color);
                }
            }
        }
        this.state = new State(state.check, state.turn);
    }
    //take a board and creates a game
    public Game(Piece[][] clone, boolean check, Piece.Color color) {
        this.board = new Piece[8][8];
        for(int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if(clone[y][x] == null) {
                    this.board[y][x] = null;
                } else {
                    this.board[y][x] = new Piece(clone[y][x].type, clone[y][x].color);
                }
            }
        }
        this.state = new State(state.check, state.turn);
    }
    //pass it a board and it creates a game with that board and a default state
    public Game(Piece[][] clone) {
        this.board = new Piece[8][8];
        for(int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if(clone[y][x] == null) {
                    this.board[y][x] = null;
                } else {
                    this.board[y][x] = new Piece(clone[y][x].type, clone[y][x].color);
                }
            }
        }
        this.state = new State();
    }

    //complete empty board and a default state
    public Game() {
        this.board = new Piece[8][8];
        this.state = new State();

        for(int x = 0; x < board[0].length; x++) {
            for(int y = 0; y < board.length; y++) {
                board[y][x] = null;
            }
        }
    }

    public void swapColor() {
        if(this.state.turn == Piece.Color.WHITE) {
            this.state.turn = Piece.Color.BLACK;
        } else {
            this.state.turn = Piece.Color.WHITE;
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        for(int y = 7; y >= 0; y--){
            for(int x = 0; x < 8; x++){
                ret.append(this.board[y][x]).append(" ");
            }
            ret.append("\n");
        }

        return ret.toString();
    }
}
