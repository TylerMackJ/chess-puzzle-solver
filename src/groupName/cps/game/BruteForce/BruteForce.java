package groupName.cps.game.BruteForce;

import groupName.cps.game.Game;
import groupName.cps.game.Movement.Move;
import groupName.cps.game.Movement.Movement;
import groupName.cps.game.Piece;

import java.util.Iterator;
import java.util.LinkedList;

public class BruteForce {
    public static boolean inCheck(Game game){
        int kingX = -1, kingY = -1;
        for (int x = 0; x < 8; x++){

            for(int y = 0; y < 8; y++){
                if (game.board[y][x].color == game.state.turn && game.board[y][x].type == Piece.Type.KING);{
                    kingX = x;
                    kingY = y;
                }
            }

        }
        Piece.Color otherColor = Piece.Color.WHITE;
        if (otherColor == game.state.turn){
            otherColor = Piece.Color.BLACK;
        }
        Game altGame = new Game(game.board,game.state.check, otherColor );
        LinkedList<Move> moveList = Movement.getMoves(altGame);

        Iterator<Move> moveListI = moveList.iterator();
        while(moveListI.hasNext()) {
            Move currentMove = moveListI.next();
            if (currentMove.destination[0] == kingX && currentMove.destination[1] == kingY){
                return true;
            }
        }
        return false;
    }
}
