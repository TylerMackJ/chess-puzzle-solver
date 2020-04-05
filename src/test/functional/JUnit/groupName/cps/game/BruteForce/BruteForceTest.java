package groupName.cps.game.BruteForce;

import groupName.cps.game.Game;
import groupName.cps.game.PopulateBoard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BruteForceTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void solvePuzzleIn1() {
        String puzzle = "BR16 WK55 WR60 BK75";
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());
        BruteForce.solvePuzzle(puzzle, 1);
        assertEquals(true,BruteForce.win(game,1));
    }

    @Test
    void solvePuzzleIn2() {
        String puzzle = "BQ60 WR21 WP02 BP52 WK72 WQ53 BP73 BR64 BP65 BK75";
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());
        BruteForce.solvePuzzle(puzzle, 2);
        assertEquals(true,BruteForce.win(game,2));
    }


    @Test
    void winTrue() {
        String puzzle = "BR16 WK55 WR60 BK75";
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());
        BruteForce.win(game, 1);
        assertEquals(true,BruteForce.win(game,1));
    }

    @Test
    void winFalse() {
        String puzzle = "BQ60 WR21 WP02 BP52 WK72 WQ53 BP73 BR64 BP65 BK75";  //cant win in 1
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());
        BruteForce.win(game, 1);
        assertEquals(false,BruteForce.win(game,1));
    }


    @Test
    void chooseMoveWin() {
        String puzzle = "BR16 WK55 WR60 BK75";
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());
        BruteForce.chooseMove(game,1);
        assertNotEquals(null,BruteForce.chooseMove( game,1));
    }

    @Test
    void chooseMoveNull() {
        String puzzle = "BQ60 WR21 WP02 BP52 WK72 WQ53 BP73 BR64 BP65 BK75";  // cant win in 1
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());
        BruteForce.chooseMove(game,1);
        assertEquals(null,BruteForce.chooseMove( game,1));
    }
}