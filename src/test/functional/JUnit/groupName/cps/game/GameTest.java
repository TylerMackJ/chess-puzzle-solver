package groupName.cps.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
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
       this.game = new Game(this.board, this.state);

       this.game1 = new Game(this.board);

       this.game2 = new Game(this.board, true, Piece.Color.WHITE);

       this.game3 = new Game();


    }

    @AfterEach
    void tearDown() {
        System.out.println(" * GameTest: tearDown()\n");
        this.state = null;
        this.board = null;
        this.board2 = null;
        this.game = null;
        this.game1 = null;
        this.game2 = null;
        this.game3 = null;

    }

    @Test
    void gameAttributes(){
        System.out.println("GameTest: gameAttributes()");
        board[1][1] = new Piece(Piece.Type.KING, Piece.Color.WHITE);

        Game g = new Game(board);

        assertNotNull(g);
    }

    @Test
    void gameAttributes1(){
        System.out.println("GameTest: gameAttributes1()");
        board[1][1] = new Piece(Piece.Type.KING, Piece.Color.WHITE);

        Game g = new Game(board,state);

        assertNotNull(g);
    }

    @Test
    void gameAttributes2(){
        System.out.println("GameTest: gameAttributes2()");
        board[1][1] = new Piece(Piece.Type.KING, Piece.Color.WHITE);

        Game g = new Game(board,true, Piece.Color.WHITE);


        assertNotNull(g);
    }

    @Test
    void gameAttributes3(){
        System.out.println("GameTest: gameAttributes3()");
        Game g = new Game();


        assertNotNull(g);
    }




    @Test
    void swapColor() {
        System.out.println("GameTest swapColor()");
        Game g = new Game();
        g.swapColor();

        assertEquals(Piece.Color.BLACK, g.state.turn);

        }


    @Test
    void swapColor1() {
        System.out.println("GameTest swapColor1()");
        Game g = new Game();
        g.swapColor();
        g.swapColor();

        assertEquals(Piece.Color.WHITE, g.state.turn);

    }


    @Test
    void testToString() {
        System.out.println("GameTest testToString()");
        Game g = new Game();
        System.out.println(g.toString());
        assertNotNull(g.toString());

    }


}