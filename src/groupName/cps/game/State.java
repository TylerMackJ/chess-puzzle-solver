package groupName.cps.game;

public class State {
    public boolean checkMate;
    public Piece.Color turn;

    public State(boolean check, Piece.Color turn) {
        this.checkMate = check;
        this.turn = turn;
    }

    public State() {
        this.checkMate = false;
        this.turn = Piece.Color.WHITE;
    }
}
