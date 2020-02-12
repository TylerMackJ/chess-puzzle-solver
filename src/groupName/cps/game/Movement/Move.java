package groupName.cps.game.Movement;

import java.util.Arrays;

public class Move {
    public int[] source = new int[2];
    public int[] destination = new int[2];

    public Move(int sourceX, int sourceY, int destinationX, int destinationY) {
        this.source[0] = sourceX;
        this.source[1] = sourceY;
        this.destination[0] = destinationX;
        this.destination[1] = destinationY;
    }

    @Override
    public String toString() {
        return "(" + source[0] + ", " + source[1] + ")->(" + destination[0] + ", " + destination[1] + ")";
    }
}