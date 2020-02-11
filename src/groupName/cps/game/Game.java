package groupName.cps.game;

import java.util.Arrays;

public class Game {
    public Piece[][] board;
    public State state;

    public Game(Piece[][] clone, State state) {
        this.board = clone.clone();
        this.state = state;
    }
    //take a board and creates a game
    public Game(Piece[][] clone, boolean check, Piece.Color color) {
        this.board = clone.clone();
        this.state = new State(check, color);
    }
    //pass it a board and it creates a game with that board and a default state
    public Game(Piece[][] clone) {
        this.board = clone.clone();
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
