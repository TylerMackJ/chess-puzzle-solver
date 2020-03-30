package groupName.cps.game.GenerateGame;

import groupName.cps.game.BruteForce.BruteForce;
import groupName.cps.game.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GenerateGameTest {

    @Test
    void generate3MoveGame() {
        Game g = GenerateGame.generateGame(3);
        assertNotEquals(null, BruteForce.chooseMove(g, 3));
    }
}