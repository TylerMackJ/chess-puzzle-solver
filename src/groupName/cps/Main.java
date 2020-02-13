package groupName.cps;
import groupName.cps.game.*;
import groupName.cps.game.Movement.Move;
import groupName.cps.game.Movement.Movement;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //(Color, Piece, X, Y
        String puzzle = "WR20 WK60 WP51 WP12 WP72 WP03 BQ33 WP63 BP04 BP34 BP65 BP56 BP66 BK76 WR17";
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());

        LinkedList<Move> moveList = Movement.getMoves(game);


        Iterator<Move> moveListI = moveList.iterator();
        while(moveListI.hasNext()) {
            System.out.println(moveListI.next());
        }
    }
}
