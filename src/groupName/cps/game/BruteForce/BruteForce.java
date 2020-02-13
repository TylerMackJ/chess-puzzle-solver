package groupName.cps.game.BruteForce;

import groupName.cps.game.Game;
import groupName.cps.game.Movement.Move;
import groupName.cps.game.Movement.Movement;
import groupName.cps.game.Piece;

import java.awt.desktop.SystemSleepEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class BruteForce {
    public static boolean inCheck(Game game){
        int kingX = -1, kingY = -1;
        for (int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(game.board[y][x] != null) {
                    if (game.board[y][x].color == game.state.turn && game.board[y][x].type == Piece.Type.KING)
                    {
                        kingX = x;
                        kingY = y;
                    }
                }
            }

        }
        Piece.Color otherColor = Piece.Color.WHITE;
        if (otherColor == game.state.turn){
            otherColor = Piece.Color.BLACK;
        }
        Game altGame = new Game(game.board,game.state.checkMate, otherColor );
        LinkedList<Move> moveList = Movement.getMovesCheck(altGame);

        Iterator<Move> moveListI = moveList.iterator();
        while(moveListI.hasNext()) {
            Move currentMove = moveListI.next();
            if (currentMove.destination[0] == kingX && currentMove.destination[1] == kingY){
                return true;
            }
        }
        return false;
    }

    public static LinkedList<Move> whiteTurn(Game game, int n) {
        /*
        LinkedList<Move> moves = Movement.getMoves(game);
        LinkedList<LinkedList<Move>> blackReturn = new LinkedList<LinkedList<Move>>();

        Iterator<Move> movesI = moves.iterator();

        while(movesI.hasNext()) {
            Move currentMove = movesI.next();
            blackReturn.add(blackTurn(makeMove(game, currentMove)));
        }

        for(Move moveCmp : blackReturn.get(0)) {
            boolean existsInAll = true;
            for(int i = 1; i < blackReturn.size(); i++) {
                if(!blackReturn.get(i).contains(moveCmp)) {
                    existsInAll = false;
                    break;
                }
            }
            if(existsInAll) {
                System.out.println(moveCmp);
                return new LinkedList<>();
            }
        }
         */
        game.state.turn = Piece.Color.WHITE;

        LinkedList<Move> moves = Movement.getMoves(game);

        if(n != 0) {
            for(Move move : moves) {
                if(blackTurn(makeMove(game, move), n) != null) {
                    System.out.println(move);
                    return new LinkedList<>();
                }
            }
        } else {
            LinkedList<Move> winningMoves = new LinkedList<>();
            for(Move move : moves) {
                game.state.turn = Piece.Color.WHITE;
                Game updatedGame = makeMove(game, move);
                updatedGame.state.turn = Piece.Color.BLACK;
                if(inCheck(updatedGame)) {
                    if(Movement.getMoves(updatedGame).size() == 0) {
                        winningMoves.add(move);
                    }
                }
            }
            return winningMoves;
        }
        return new LinkedList<>();
    }

    public static Move blackTurn(Game game, int n) {
        LinkedList<LinkedList<Move>> winningMovesList = new LinkedList<>();

        game.state.turn = Piece.Color.BLACK;
        LinkedList<Move> moves = Movement.getMoves(game);

        for(Move move : moves) {
            winningMovesList.add(whiteTurn(makeMove(game, move), n - 1));
        }

        for(Move moveCmp : winningMovesList.get(0)) {
            boolean existsInAll = true;
            for(int i = 1; i < winningMovesList.size(); i++) {
                if(!winningMovesList.get(i).contains(moveCmp)) {
                    existsInAll = false;
                    break;
                }
            }
            if(existsInAll) {
                System.out.println(moveCmp);
                return moveCmp;
            }
        }
        return null;
    }

    public static Game makeMove(Game game, Move move){
        Game updatedGame = new Game(game.board, game.state);
        // en-passants
        if (game.board[move.source[1]][move.source[0]].type == Piece.Type.PAWN){
            if(move.source[0] != move.destination[0]){
                if(game.board[move.destination[1]][move.destination[0]] == null){
                    if(game.board[move.source[1]][move.source[0]].color == Piece.Color.WHITE){
                       updatedGame.board[move.destination[1] - 1][move.destination[0]] = null;
                    }
                    else {
                        updatedGame.board[move.destination[1] + 1][move.destination[0]] = null;
                    }
                }
            }
        }
        updatedGame.board[move.destination[1]][move.destination[0]] = updatedGame.board[move.source[1]][move.source[0]];
        updatedGame.board[move.source[1]][move.source[0]] = null;

        return updatedGame;
    }

}


