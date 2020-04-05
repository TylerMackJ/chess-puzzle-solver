package groupName.cps.game.Movement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoveTestStruct {



    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        Move m = new Move(1,2,3,4);
        assertEquals("(1, 2)->(3, 4)",m.toString());
    }

    @Test
    void testEqualsTrue() {
        Move m = new Move(1,2,3,4);
        Move g = new Move(1,2,3,4);
        assertEquals(true,m.equals(g));
    }

    @Test
    void testEqualsFalse() {
        Move m = new Move(1,2,3,4);
        Move g = new Move(1,2,3,5);
        assertEquals(false,m.equals(0));
    }


    @Test
    void testHashCode() {
        Move m = new Move(1,2,3,4);
        assertEquals(31872,m.hashCode());
    }
}