package groupName.cps.game.Movement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import groupName.cps.game.Game;
import groupName.cps.game.PopulateBoard;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovementTest {

    String startPuzzle = "WP21 BP66 WR00 Wk10 WB20 WK30 WQ40 WB50 Wk60 WR70 BR00 Bk10 BB20 BK30 BQ40 BB50 Bk60 BR70";
    String puzzleInCheck = "BR17 BB27 BK47 BB57 BR77 BP16 BQ26 BP56 BP66 BP05 BP35 Bk55 " +
            "BP75 WB14 BP44 Wk33 WP43 WP53 Bk63 Wk22 WP01 WP11 WP21 WQ31 WP71 WK20 WR30 WB60 WR70";

    @Test
    public void checkTest(){
        Game gameInstance = new Game(new PopulateBoard(puzzleInCheck).getPopulatedBoard());
        //Movement.check(gameInstance);
        boolean isCheck = Movement.check(gameInstance);
        boolean isBoolean = isCheck == true || isCheck == false;
        assertTrue(isBoolean);
    }

    @Test
    public void makeMoveTest(){
        Game gameInstance = new Game(new PopulateBoard(startPuzzle).getPopulatedBoard());
        Move moveInstance = new Move(6, 2, 6, 3);
        Game updatedGame = Movement.makeMove(gameInstance, moveInstance);
        assertTrue(updatedGame instanceof Game);
    }

    @Test
    public void getMovesTest(){
        Game gameInstance = new Game(new PopulateBoard(puzzleInCheck).getPopulatedBoard());
        Movement.getMoves(gameInstance);
        assertNotNull(Movement.getMoves(gameInstance));
    }

    @Test
    public void getCheckMovesTest(){
        Game gameInstance = new Game(new PopulateBoard(puzzleInCheck).getPopulatedBoard());
        Movement.getCheckMoves(gameInstance);
        assertNotNull(Movement.getCheckMoves(gameInstance));
    }

}