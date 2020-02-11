package groupName.cps;

import groupName.cps.game.Game;
import groupName.cps.game.Move;
import groupName.cps.game.Piece;

import java.util.LinkedList;

public class Movement {
    //reading the board and calling legal moves on any white spots by passing the board
    // and the position of the white piece
    //legalMovesKing(), legalMovesQueen()...
    //each should return a sublist of legal moves

    public static Move[] getMoves(Game game) {
        LinkedList<Move> moveList = new LinkedList<Move>();
        for(int y = 7; y >= 0; y--){
            for(int x = 0; x < 8; x++){
                if (game.board[y][x] != null) {
                    if (game.board[y][x].color == game.state.turn){
                        moveList.addAll(legalMoves(x, y, game));
                    }
                }
            }
        }
    }


    //takes board and piece
    private static LinkedList<Move> legalMoves ( int x, int y, Game game){
        Piece.Type type = game.board[y][x].type;

        switch (type) {
            case KING:
                return legalMovesKing(x, y, game);
            break;

        }
    }

    private static LinkedList<Move> legalMovesPawn(int x, int y, Game game){
        LinkedList<Move> moveList = new LinkedList<Move>();
        if (game.board[y+1][x] == null){
            moveList.add(new Move(x, y, x, y+1));
        }
        if (game.board[y+2]){

        }
        //en passant left
        //check if there is pawn of opposite color to left and space behind it is empty
        if (game.board[y][x+1]){

        }
        //en passant right

    }

    //function that takes a game and return an array of move objects that can be made on that turn
    //check the turn
    //loop over every spot on the board and check if there is a piece and what color the piece is
    //game.state.turn will tell you white vs black
    //hard code all possible moves for each piece
}
