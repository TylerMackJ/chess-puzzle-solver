package groupName.cps.game.Movement;

import groupName.cps.game.Game;
import groupName.cps.game.PopulateBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovementTestStruct {
    String kingKillPuzzle = "WK11 BP00 BP10 BP20 BP01 BP21 BP02 BP12 BP22";
    String kingMovePuzzle = "WK44";
    String knightPuzzle = "BP31 BP51 BP22 BP62 Wk43 BP24 BP64 BP35 BP55";
    String bishopPuzzle = "WB22 BP00";
    String rookPuzzle = "WR44 BP43 BP45 BP34 BP54";
    @Test
    public void getMovesTestKingKill(){
        Game gameInstance = new Game(new PopulateBoard(kingKillPuzzle).getPopulatedBoard());
        Movement.getMoves(gameInstance);
        assertNotNull(Movement.getMoves(gameInstance));
    }
    @Test
    public void getMovesTestKingMove(){
        Game gameInstance = new Game(new PopulateBoard(kingMovePuzzle).getPopulatedBoard());
        Movement.getMoves(gameInstance);
        assertNotNull(Movement.getMoves(gameInstance));
    }
    @Test
    public void getMovesTestKnight(){
        Game gameInstance = new Game(new PopulateBoard(knightPuzzle).getPopulatedBoard());
        Movement.getMoves(gameInstance);
        assertNotNull(Movement.getMoves(gameInstance));
    }
    @Test
    public void getMovesTestBishop(){
        Game gameInstance = new Game(new PopulateBoard(bishopPuzzle).getPopulatedBoard());
        Movement.getMoves(gameInstance);
        assertNotNull(Movement.getMoves(gameInstance));
    }
    @Test
    public void getMovesTestRook(){
        Game gameInstance = new Game(new PopulateBoard(rookPuzzle).getPopulatedBoard());
        Movement.getMoves(gameInstance);
        assertNotNull(Movement.getMoves(gameInstance));
    }
}