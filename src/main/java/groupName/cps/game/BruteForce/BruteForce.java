package groupName.cps.game.BruteForce;

import groupName.cps.game.Game;
import groupName.cps.game.Movement.Move;
import groupName.cps.game.Movement.Movement;
import groupName.cps.game.Piece;
import groupName.cps.game.PopulateBoard;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.List;

public class BruteForce {
    public static LinkedList<Move> solvePuzzle(String puzzle, int n) {
        Game game = new Game(new PopulateBoard(puzzle).getPopulatedBoard());
        LinkedList<Move> winningMoves = new LinkedList<Move>();

        for(; n > 0; n--) {
            Move mv = BruteForce.chooseMove(game, n);
            if(mv == null) { break; }
            System.out.println(mv);
            winningMoves.add(mv);
            game = Movement.makeMove(game, mv);
            game.swapColor();
            LinkedList<Move> moveList = Movement.getMoves(game);
            if(!moveList.isEmpty()) {
                game = Movement.makeMove(game, moveList.get(0));
            }
            game.swapColor();
        }
        return winningMoves;
    }

    public static LinkedList<Move> solvePuzzle(Game g, int n) {
        Game game = new Game(g.board, g.state);
        LinkedList<Move> winningMoves = new LinkedList<Move>();

        for(; n > 0; n--) {
            Move mv = BruteForce.chooseMove(game, n);
            if(mv == null) { break; }
            System.out.println(mv);
            winningMoves.add(mv);
            game = Movement.makeMove(game, mv);
            game.swapColor();
            LinkedList<Move> moveList = Movement.getMoves(game);
            if(!moveList.isEmpty()) {
                game = Movement.makeMove(game, moveList.get(0));
            }
            game.swapColor();
        }
        return winningMoves;
    }

    public static boolean win(Game game, int n) {
        // If its black turn and black is in checkmate then it is a win
        if(game.state.turn == Piece.Color.BLACK && Movement.check(game) && Movement.getCheckMoves(game).isEmpty()) {
            return true;
        }
        // If the player has ran out of moves then it is not a win
        if(n == 0) { return false; }

        if(game.state.turn == Piece.Color.WHITE) {
            LinkedList<Move> moveList = Movement.getMoves(game);
            for(Move move : moveList) {
                Game updatedGame = Movement.makeMove(game, move);
                updatedGame.swapColor();
                if(win(updatedGame, n - 1)) {
                    return true;
                }
            }
            return false;
        }

        LinkedList<Move> moveList = Movement.getMoves(game);
        for(Move move : moveList) {
            Game updatedGame = Movement.makeMove(game, move);
            updatedGame.swapColor();
            if(!win(updatedGame, n)) {
                return false;
            }
        }
        return true;
    }

    public static Move chooseMove(Game game, int n) {
        game.state.turn = Piece.Color.WHITE;

        LinkedList<Move> moveList = Movement.getMoves(game);
        for(Move move : moveList) {
            Game currentGame = Movement.makeMove(game, move);
            currentGame.swapColor();
            if(win(currentGame, n - 1)) {
                return move;
            }
        }
        return null;
    }
}
