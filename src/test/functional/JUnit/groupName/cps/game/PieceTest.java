package groupName.cps.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


class PieceTest {
    Piece pieceInstance;
    String pieceString1 = "Bk";
    String pieceString2 = "WQ";
    String pieceString3 = "BB";
    String pieceString4 = "WR";
    String pieceString5 = "WP";



    @BeforeEach
    void setUp() {
        this.pieceInstance = new Piece(pieceString1);
        this.pieceInstance = new Piece(pieceString2);
        this.pieceInstance = new Piece(pieceString3);
        this.pieceInstance = new Piece(pieceString4);
        this.pieceInstance = new Piece(pieceString5);
    }

    @AfterEach
    void tearDown() {
        this.pieceInstance = null;
    }

    @Test
    void testToString() {
        System.out.println("testToString()");
        Piece piece = new Piece(Piece.Type.KING, Piece.Color.WHITE);
        String pieceString = "WK";
        this.pieceInstance = new Piece(pieceString);
        piece.toString();
        assertNotEquals(true,piece.toString());
    }

    @Test
    void testToString1() {
        System.out.println("testToString1()");
        Piece piece1 = new Piece(Piece.Type.QUEEN, Piece.Color.BLACK);
        String pieceString = "Qk";
        piece1.toString();
        assertNotEquals(false, piece1.toString());
    }

}