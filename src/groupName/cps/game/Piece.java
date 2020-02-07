package groupName.cps.game;

public class Piece {
    public enum Type {
        KING, QUEEN, BISHOP, KNIGHT, ROOK, PAWN
    }
    public enum Color {
        BLACK, WHITE
    }

    public Type type;
    public Color color;

    Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }
}
