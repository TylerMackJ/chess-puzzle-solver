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
    private static LinkedList<Move> legalMoves(int x, int y, Game game){
        Piece.Type type = game.board[y][x].type;

        switch (type) {
            case KING: return legalMovesKing(x, y, game);
            break;
            case QUEEN: return legalMovesQueen(x, y, game);
            break;
            case KNIGHT: return legalMovesKnight(x, y, game);
            break;
            case BISHOP: return legalMovesBishop(x, y, game);
            break;
            case ROOK: return legalMovesRook(x, y, game);
            break;
            case PAWN: return legalMovesPawn(x, y, game);
            break;
        }
    }

    private static LinkedList<Move> legalMovesPawn(int x, int y, Game game){
        LinkedList<Move> moveList = new LinkedList<Move>();
        Piece.Type pawn = game.board[y][x].type;
        Piece.Color pawnColor = game.board[y][x].color;

        int direction = 1;
        //if it's black's turn, move opposite direction
        if (game.state.turn == Piece.Color.BLACK) {
            direction = -1;
        }
        //move forward 1 space
        if(inBounds(y+direction)) {
            if (game.board[y + direction][x] == null) {
                moveList.add(new Move(x, y, x, y + direction));
            }
        }
        //move forward 2 spaces if never moved
        if(inBounds(y+(direction*2))) {
            if ((game.board[y + (direction * 2)][x] == null)
                    && ((y == 1 && direction == 1) || (y == 6 && direction == -1))) {
                moveList.add(new Move(x, y, x, (y + (direction * 2))));
            }
        }
        //kill left
        if (inBounds(y+direction) && inBounds(x-1)) {
            if ((game.board[y + direction][x - 1] != null) && (game.board[y + direction][x - 1].color != pawnColor)) {
                moveList.add(new Move(x, y, x - 1, y + direction));
            }
        }
        //kill right
        if(inBounds(y+direction) && inBounds(x+direction)) {
            if ((game.board[y + direction][x + direction] != null) && (game.board[y + direction][x + direction].color != pawnColor)) {
                moveList.add(new Move(x, y, x + direction, y + direction));
            }
        }
        //en passant right
        if (inBounds(x+1) && inBounds(y+direction) && inBounds(x+direction)) {
            if ((game.board[y + direction][x + direction] == null) &&
                    (game.board[y][x + direction].type == Piece.Type.PAWN) &&
                    (game.board[y][x + direction].color != pawnColor)) {
                moveList.add(new Move(x, y, x + 1, y + direction));
            }
        }
        //en passant left
        if (inBounds(y+direction) && inBounds(x-direction) && inBounds(y+direction) && inBounds(x-1)) {
            if ((game.board[y + direction][x - direction] == null) &&
                    (game.board[y][x - direction].type == pawn) &&
                    (game.board[y][x - direction].color != pawnColor)) {
                moveList.add(new Move(x, y, x - 1, y + direction));
            }
        }
        //NEED TO RETURN THE LINKED LIST SOMEHOW???
        return moveList;
    }


    //check if any adjacent space is null and add it as a possible move if so
    //check if piece in adjacent space if opposite color and move to that space if so
    private static LinkedList<Move> legalMovesKing(int x, int y, Game game) {
        LinkedList<Move> moveList = new LinkedList<Move>();
        Piece.Color kingColor = game.board[y][x].color;

        //move/kill up
        if (inBounds(y+1)) {
            if ((game.board[y + 1][x] == null) || (game.board[y + 1][x].color != kingColor)) {
                moveList.add(new Move(x, y, x, y + 1));
            }
        }
        //move/kill down
        if (inBounds(y-1)) {
            if ((game.board[y - 1][x] == null) || (game.board[y - 1][x].color != kingColor)) {
                moveList.add(new Move(x, y, x, y - 1));
            }
        }
        //move/kill left
        if (inBounds(x-1)) {
            if ((game.board[y][x - 1] == null) || (game.board[y][x - 1].color != kingColor)) {
                moveList.add(new Move(x, y, x - 1, y));
            }
        }
        //move/kill right
        if (inBounds(x+1)) {
            if ((game.board[y][x + 1] == null) || (game.board[y][x + 1].color != kingColor)) {
                moveList.add(new Move(x, y, x + 1, y));
            }
        }
        //move/kill up-right
        if (inBounds(y+1) && inBounds(x+1)) {
            if ((game.board[y + 1][x + 1] == null) || (game.board[y + 1][x + 1].color != kingColor)) {
                moveList.add(new Move(x, y, x + 1, y + 1));
            }
        }
        //move/kill up-left
        if (inBounds(y+1) && inBounds(x-1)) {
            if ((game.board[y + 1][x - 1] == null) || (game.board[y + 1][x - 1].color != kingColor)) {
                moveList.add(new Move(x, y, x - 1, y + 1));
            }
        }
        //move/kill down-right
        if (inBounds(y-1) && inBounds(x+1)) {
            if ((game.board[y - 1][x + 1] == null) || (game.board[y - 1][x + 1].color != kingColor)) {
                moveList.add(new Move(x, y, x + 1, y - 1));
            }
        }
        //move/kill down-left
        if (inBounds(y-1) && inBounds(x-1)) {
            if ((game.board[y - 1][x - 1] == null) || (game.board[y - 1][x - 1].color != kingColor)) {
                moveList.add(new Move(x, y, x - 1, y - 1));
            }
        }
        return moveList;
    }


    private static LinkedList<Move> legalMovesQueen(int x, int y, Game game) {
        LinkedList<Move> moveList = new LinkedList<Move>();
        //ADD THE LINKED LIST FROM legalMovesKing() HERE???
        return moveList;
    }

    private static LinkedList<Move> legalMovesKnight(int x, int y, Game game) {//DONE
        LinkedList<Move> moveList = new LinkedList<Move>();
        Piece.Color knightColor = game.board[y][x].color;

        //Forward 2, Right 1
        if ((inBoundDiag(y+2, x+1)) && (game.board[y+2][x+1] == null)) {
            moveList.add(new Move(x, y, x+1, y+2));
        }
        //kill
        if ((inBoundDiag(y+2, x+1)) && (game.board[y+2][x+1].color != knightColor)) {
            moveList.add(new Move(x, y, x+1, y+2));
        }
        //Forward 2, Left 1
        if ((inBoundDiag(y+2, x-1)) && (game.board[y+2][x-1] == null)) {
            moveList.add(new Move(x, y, x-1, y+2));
        }
        //kill
        if ((inBoundDiag(y+2, x-1)) && (game.board[y+2][x-1].color != knightColor)) {
            moveList.add(new Move(x, y, x-1, y+2));
        }
        //Forward 1, Left 2
        if ((inBoundDiag(y+1, x-2)) && (game.board[y+1][x-2] == null)) {
            moveList.add(new Move(x, y, x-2, y+1));
        }
        //kill
        if ((inBoundDiag(y+1, x-2)) && (game.board[y+1][x-2].color != knightColor)) {
            moveList.add(new Move(x, y, x-2, y+1));
        }
        //Forward 1, Right 2
        if ((inBoundDiag(y+1, x+2)) && (game.board[y+1][x+2] == null)) {
            moveList.add(new Move(x, y, x+2, y+1));
        }
        //kill
        if ((inBoundDiag(y+1, x+2)) && (game.board[y+1][x+2].color != knightColor)) {
            moveList.add(new Move(x, y, x+2, y+1));
        }
        //Back 2, Right 1
        if ((inBoundDiag(y-2, x+1)) && (game.board[y-2][x+1] == null)) {
            moveList.add(new Move(x, y, x+1, y-2));
        }
        //kill
        if ((inBoundDiag(y-2, x+1)) && (game.board[y-2][x+1].color != knightColor)) {
            moveList.add(new Move(x, y, x+1, y-2));
        }
        //Back 2, Left 1
        if ((inBoundDiag(y-2, x-1)) && (game.board[y-2][x-1] == null)) {
            moveList.add(new Move(x, y, x-1, y-2));
        }
        //kill
        if ((inBoundDiag(y-2, x-1)) && (game.board[y-2][x-1].color != knightColor)) {
            moveList.add(new Move(x, y, x-1, y-2));
        }
        //Back 1, Left 2
        if ((inBoundDiag(y-1, x-2)) && (game.board[y-1][x-2] == null)) {
            moveList.add(new Move(x, y, x-2, y-1));
        }
        //kill
        if ((inBoundDiag(y-1, x-2)) && (game.board[y-1][x-2].color != knightColor)) {
            moveList.add(new Move(x, y, x-2, y-1));
        }
        //Back 1, Right 2
        if ((inBoundDiag(y-1, x+2)) && (game.board[y-1][x+2] == null)) {
            moveList.add(new Move(x, y, x+2, y-1));
        }
        //kill
        if ((inBoundDiag(y-1, x+2)) && (game.board[y-1][x+2].color != knightColor)) {
            moveList.add(new Move(x, y, x+2, y-1));
        }
        return moveList;
    }

    private static LinkedList<Move> legalMovesBishop(int x, int y, Game game) {
        LinkedList<Move> moveList = new LinkedList<Move>();
        Piece.Color bishopColor = game.board[y][x].color;
        //move diagonal up and to the right
        for (int lcv=1; lcv<=7; lcv++){
            if ((game.board[y+lcv][x+lcv] == null) && (inBoundDiag(x+lcv, y+lcv))) {
                moveList.add(new Move(x, y, x+lcv, y+lcv));
            } else {
                break;
            }
            //kill
            if ((game.board[y+lcv][x+lcv] != null) && inBoundDiag(x+lcv, y+lcv)) {
                if (game.board[y+lcv][x+lcv].color != bishopColor){
                    moveList.add(new Move(x, y, x+lcv, y+lcv));
                }
                break;
            }
        }
        //move diagonal up and to the left
        for (int lcv=1; lcv<=7; lcv++){
            if ((game.board[y+lcv][x-lcv] == null) && (inBoundDiag(x-lcv, y+lcv))) {
                moveList.add(new Move(x, y, x-lcv, y+lcv));
            } else {
                break;
            }
            //kill
            if ((game.board[y+lcv][x-lcv] != null) && inBoundDiag(x-lcv, y+lcv)) {
                if (game.board[y+lcv][x-lcv].color != bishopColor){
                    moveList.add(new Move(x, y, x-lcv, y+lcv));
                }
                break;
            }
        }
        //move diagonal down and to the right
        for (int lcv=1; lcv<=7; lcv++){
            if ((game.board[y-lcv][x+lcv] == null) && (inBoundDiag(x+lcv, y-lcv))) {
                moveList.add(new Move(x, y, x+lcv, y-lcv));
            } else {
                break;
            }
            //kill
            if ((game.board[y-lcv][x+lcv] != null) && inBoundDiag(x+lcv, y-lcv)) {
                if (game.board[y-lcv][x+lcv].color != bishopColor){
                    moveList.add(new Move(x, y, x+lcv, y-lcv));
                }
                break;
            }
        }
        //move diagonal down and to the left
        for (int lcv=1; lcv<=7; lcv++){
            if ((game.board[y-lcv][x-lcv] == null) && (inBoundDiag(x-lcv, y-lcv))) {
                moveList.add(new Move(x, y, x-lcv, y-lcv));
            } else {
                break;
            }
            //kill
            if ((game.board[y-lcv][x-lcv] != null) && inBoundDiag(x-lcv, y-lcv)) {
                if (game.board[y-lcv][x-lcv].color != bishopColor){
                    moveList.add(new Move(x, y, x-lcv, y-lcv));
                }
                break;
            }
        }
        return moveList;
    }

    private static LinkedList<Move> legalMovesRook(int x, int y, Game game) {
        LinkedList<Move> moveList = new LinkedList<Move>();
        Piece.Color rookColor = game.board[y][x].color;

        //move forward
        for (int lcv=y; lcv<=6; lcv++){
            if (inBounds(lcv+1) && (game.board[lcv+1][x] == null)) {
                moveList.add(new Move(x, y, x, lcv+1));
            } else {
                break;
            }
            if ((game.board[lcv+1][x] != null) && inBounds(lcv+1)) {
                if(game.board[lcv+1][x].color != rookColor) {
                    moveList.add(new Move(x, y, x, lcv+1));
                }
                break;
            }
        }
        //move backward
        for (int lcv=y; lcv<=6; lcv--){
            if (inBounds(lcv-1) && (game.board[lcv-1][x] == null)){
                moveList.add(new Move(x, y, x, lcv-1));
            } else {
                break;
            }
            if ((game.board[lcv-1][x] != null) && inBounds(lcv-1)) {
                if(game.board[lcv-1][x].color != rookColor) {
                    moveList.add(new Move(x, y, x, lcv-1));
                }
                break;
            }
        }
        //move left
        for (int lcv=x; lcv<=6; lcv--){
            if (inBounds(lcv-1) && (game.board[y][lcv-1] == null)){
                moveList.add(new Move(x, y, lcv-1, y));
            } else {
                break;
            }
            if ((game.board[y][lcv-1] != null) && inBounds(lcv-1)) {
                if(game.board[y][lcv-1].color != rookColor) {
                    moveList.add(new Move(x, y, lcv-1, y));
                }
                break;
            }
        }
        //move right
        for (int lcv=x; lcv<=6; lcv++){
            if (inBounds(lcv+1) && (game.board[y][lcv+1] == null)){
                moveList.add(new Move(x, y, lcv+1, y));
            } else {
                break;
            }
            if ((game.board[y][lcv+1] != null) && inBounds(lcv+1)){
                if (game.board[y][lcv+1].color != rookColor) {
                    moveList.add(new Move(x, y, lcv+1, y));
                }
            }
        }
        return moveList;
    }

    //test a point to determine if inbounds
    private static boolean inBounds(int x){
        if ((x >= 0) && (x <= 7)){
            return true;
        }else {
            return false;
        }
    }
    //test a point to determine if inbounds
    private static boolean inBoundDiag(int x, int y){
        if (((x >= 0) && (x <= 7)) && ((y >= 0) && (y <= 7))){
            return true;
        }else {
            return false;
        }
    }
}
