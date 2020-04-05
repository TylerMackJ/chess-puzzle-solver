package groupName.cps.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTestStruct {
    State state;
    Piece[][] board;
    Game game;

    State state1;
    Game game1;

    State state2;
    Game game2;

    Game game3;

    Piece[][] board2;

    Piece[][] clone;

    @BeforeEach
    void setUp() {
        System.out.println(" * GameTest: setUp()\n");
        this.board = new Piece[8][8];
        this.state = new State(true, Piece.Color.WHITE);
        this.game = new Game(board, state);


        this.game1 = new Game(board);

        this.game3 = new Game();
    }

    @AfterEach
    void tearDown() {
        System.out.println(" * GameTest: tearDown()\n");
        this.state = null;
        this.board = null;
        this.game = null;
        this.game1 = null;
        this.game2 = null;
        this.board2 = null;
    }

    @Test
    void swapColor() {
    }

    @Test
    void testToString() {
    }
}