package groupName.cps.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StateTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    State s = new State();


    @Test
    void getState1() {
        System.out.println("StateTest getState1()");
        State s1 = new State();
        assertNotEquals(true,s1);
        System.out.println(s1);
    }

    @Test
    void getState2() {
        System.out.println("StateTest getState2()");
        State s2 = new State(false, Piece.Color.WHITE);
        assertNotEquals(true,s2);
        System.out.println(s2);
    }
}