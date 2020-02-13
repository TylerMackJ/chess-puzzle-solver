package groupName.cps;
import groupName.cps.game.*;
import groupName.cps.game.BruteForce.BruteForce;
import groupName.cps.game.Movement.Move;
import groupName.cps.game.Movement.Movement;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //(Color, Piece, X, Y
        String puzzle = "BR71 WK25 WQ16 BK37";
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());

        BruteForce.whiteTurn(game, 0);
    }
}
