package groupName.cps.game.Rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import groupName.cps.game.Piece;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PieceLocation {
    public String pieceString;

    public PieceLocation() {}

    public Piece getPiece() {
        return new Piece(pieceString.substring(0,2));
    }

    public int[] getLocation() {
        int[] xy = new int[2];
        xy[0] = Integer.parseInt(String.valueOf(pieceString.charAt(2)));
        xy[1] = Integer.parseInt(String.valueOf(pieceString.charAt(3)));
        return xy;
    }
}
