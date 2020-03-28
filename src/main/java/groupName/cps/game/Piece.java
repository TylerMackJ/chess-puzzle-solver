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

    public Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Piece(String pieceString) {
        char[] currentCharacters = pieceString.toCharArray();

        switch (currentCharacters[0]){
            case 'W': this.color = Piece.Color.WHITE;
                break;
            case 'B': this.color = Piece.Color.BLACK;
                break;
        }

        // Determine what the piece type is
        switch (currentCharacters[1]){
            case 'K': this.type = Piece.Type.KING;
                break;
            case 'Q': this.type = Piece.Type.QUEEN;
                break;
            case 'k': this.type = Piece.Type.KNIGHT;
                break;
            case 'B': this.type = Piece.Type.BISHOP;
                break;
            case 'R': this.type = Piece.Type.ROOK;
                break;
            case 'P': this.type = Piece.Type.PAWN;
                break;
        }
    }

    @Override
    public String toString(){
        return this.color + " " + this.type;
    }
}
