package groupName.cps.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PopulateBoardTest {

    PopulateBoard populateBoardInstance;
    Piece[][] populatedBoard;

    @AfterEach
    public void tearDown() {
        System.out.println(" * PopulateBoardTest: tearDown()\n");
        this.populateBoardInstance = null;
        this.populatedBoard = null;
    }

    @Test
    public void pieceColorTest() {
        /*
        * This tests the partition of valid piece colors
        *
        * Valid Piece Colors = ['W', 'B']
        * */
        System.out.println(" * PopulateBoardTest: pieceColorTest()\n");

        String puzzle = "WK00 BK01";
        this.populateBoardInstance = new PopulateBoard(puzzle);
        this.populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }

    @Test
    public void pieceTypeTest() {
        /*
         * This tests the partition of valid piece types
         *
         * Valid Piece Types = ['K', 'Q', 'k', 'B', 'R', 'P']
         * */
        System.out.println(" * PopulateBoardTest: pieceTypeTest()\n");

        String puzzle = "WK01 WQ02 Wk03 WB04 WR04 WP05";
        this.populateBoardInstance = new PopulateBoard(puzzle);
        this.populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }

    @Test
    public void pieceXCoordinateTest() {
        /*
         * This tests the partition of valid piece x-coordinates
         *
         * Valid Piece X-Coordinates = [0:7]
         * */
        System.out.println(" * PopulateBoardTest: pieceXCoordinateTest()\n");

        String puzzle = "WK00 WQ10 Wk20 WB30 WR40 WP50 WP60 WP70";
        this.populateBoardInstance = new PopulateBoard(puzzle);
        this.populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }

    @Test
    public void pieceYCoordinateTest() {
        /*
         * This tests the partition of valid piece x-coordinates
         *
         * Valid Piece Y-Coordinates = [0:7]
         * */
        System.out.println(" * PopulateBoardTest: pieceYCoordinateTest()\n");

        String puzzle = "WK00 WQ01 Wk02 WB03 WR04 WP05 WP06 WP07";
        this.populateBoardInstance = new PopulateBoard(puzzle);
        this.populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }
}