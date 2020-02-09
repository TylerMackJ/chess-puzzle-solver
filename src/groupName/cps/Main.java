package groupName.cps;
import groupName.cps.game.*;

public class Main {
    public static void main(String[] args) {
        String puzzle = "WP21 WP71 WK70 WP02 BQ22 BP24 WQ34 BP54 BR64 BP15 WR65 BP75 WR06 BP56 BR27 BK77";
        Piece[][] board = new PopulateBoard(puzzle).getPopulatedBoard();
        Game game = new Game(board);

        System.out.println(game);
    }
}
