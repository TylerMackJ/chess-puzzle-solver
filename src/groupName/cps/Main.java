package groupName.cps;
import groupName.cps.game.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Chess Puzzle Solver");

        Game game = new Game();

        Main.populateBoardTest(game.board);
    }

    public static void populateBoardTest(Piece[][] testBoard) {
        String sampleLocations = "WP21 WP71 WK70 WP02 BQ22 BP24 WQ34 BP54 BR64 BP15 WR65 BP75 WR06 BP56 BR27 BK77";

        PopulateBoard popObject = new PopulateBoard(testBoard, sampleLocations);

        Piece[][] updatedBoard = popObject.getPopulatedBoard();

        for(int y=7; y>=0; y--){
            for(int x=0; x<8; x++){
                System.out.print(updatedBoard[x][y]+" ");
            }
            System.out.println("");
        }
    }
}
