package groupName.cps.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTestStruct {
    Piece pieceInstance;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
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