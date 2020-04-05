package groupName.cps;
import groupName.cps.game.*;
import groupName.cps.game.BruteForce.BruteForce;
import groupName.cps.game.GenerateGame.GenerateGame;
import groupName.cps.game.Movement.Move;
import groupName.cps.game.Movement.Movement;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String enPassantPuzzle = "WP33 BP23";
        Game gameInstance = new Game(new PopulateBoard(enPassantPuzzle).getPopulatedBoard());
        System.out.println(gameInstance);
        System.out.println(Movement.getMoves(gameInstance));
    }
}
