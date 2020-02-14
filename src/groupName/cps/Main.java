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
        BruteForce.solvePuzzle("WK11 BQ50 BR32 WP13 BP14 WP24 WP05 BB25 WP35 BP06 WR76 BK17", 3);
    }
}
