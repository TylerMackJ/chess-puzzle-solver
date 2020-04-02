package groupName.cps.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PopulateBoardTestStruct {
    PopulateBoard populateBoardInstance;
    Piece[][] populatedBoard;
    String puzzle1 = "BQ30 WP22 WP04 WB44 WK54 BP74 BK75 WR26";
    String puzzle2 = "BP21 WP02 BR32 BP15 WK25 WP55 BP06 WP36 WR66 BK37";
    String puzzle3 = "WK01 WQ21 WB61 WP02 WP62 WP03 WR37 BQ40 BR41 BP04 BK05 BP15 BP55 BP66 BP76";
    String puzzle4 = "WB10 WK60 WP61 WP62 BP44 BP15 WQ65 BQ26 BB56 WB66 BR27 BK67";
    String puzzle5 = "WK60 BQ11 WB61 WB71 WR42 WB03 BP34 BP05 BP16 BP56 BB66 BP76 Bk77 WP55";

    @BeforeEach
    void setUp() {
        System.out.println(" * PopulateBoardTestStruct: setUp()\n");
        this.populateBoardInstance = new PopulateBoard(this.puzzle1);
    }

    @AfterEach
    void tearDown() {
        System.out.println(" * PopulateBoardTestStruct: tearDown()\n");
        this.populateBoardInstance = null;
        this.populatedBoard = null;
    }

    @Test
    void getPopulatedBoardTest1() {
        System.out.println(" * PopulateBoardTestStruct: getPopulatedBoardTest1()\n");
        Piece[][] populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }

    @Test
    void getPopulatedBoardTest2() {
        System.out.println(" * PopulateBoardTestStruct: getPopulatedBoardTest2()\n");
        this.populateBoardInstance.pieceLocations = puzzle2;
        Piece[][] populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }

    @Test
    void getPopulatedBoardTest3() {
        System.out.println(" * PopulateBoardTestStruct: getPopulatedBoardTest3()\n");
        this.populateBoardInstance.pieceLocations = puzzle3;
        Piece[][] populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }

    @Test
    void getPopulatedBoardTest4() {
        System.out.println(" * PopulateBoardTestStruct: getPopulatedBoardTest4()\n");
        this.populateBoardInstance.pieceLocations = puzzle4;
        Piece[][] populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }

    @Test
    void getPopulatedBoardTest5() {
        System.out.println(" * PopulateBoardTestStruct: getPopulatedBoardTest5()\n");
        this.populateBoardInstance.pieceLocations = puzzle5;
        Piece[][] populatedBoard = this.populateBoardInstance.getPopulatedBoard();
        assertNotNull(populatedBoard);
    }
}