package groupName.cps.game.GenerateGame;

import groupName.cps.game.BruteForce.BruteForce;
import groupName.cps.game.Game;
import groupName.cps.game.Piece;

import java.util.Random;

public class GenerateGame {
    public static Game generateGame(int movesToWin) {
        if (movesToWin <= 0) {
            return null;
        }

        Random rand = new Random();

        boolean done = false;
        Game game = new Game();

        Piece bK = new Piece(Piece.Type.KING, Piece.Color.BLACK);
        Piece wK = new Piece(Piece.Type.KING, Piece.Color.WHITE);

        game.board[rand.nextInt(8)][rand.nextInt(8)] = bK;
        int wKX = rand.nextInt(8);
        int wKY = rand.nextInt(8);
        while (game.board[wKY][wKX] != null) {
            wKX = rand.nextInt(8);
            wKY = rand.nextInt(8);
        }
        game.board[wKY][wKX] = wK;

        while (true) {
            Piece.Type type;
            switch (rand.nextInt(5)) {
                case 0:
                    type = Piece.Type.QUEEN;
                    break;
                case 2:
                    type = Piece.Type.BISHOP;
                    break;
                case 3:
                    type = Piece.Type.KNIGHT;
                    break;
                case 4:
                    type = Piece.Type.ROOK;
                    break;
                default:
                    type = Piece.Type.PAWN;
            }

            Piece.Color color;
            if (rand.nextInt(2) == 1) {
                color = Piece.Color.BLACK;
            } else {
                color = Piece.Color.WHITE;
            }

            Piece p = new Piece(type, color);

            game.board[rand.nextInt(8)][rand.nextInt(8)] = p;

            if (BruteForce.chooseMove(game, movesToWin) != null) {
                return game;
            }
        }
    }
}
