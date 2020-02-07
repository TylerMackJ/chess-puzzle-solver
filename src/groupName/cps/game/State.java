package groupName.cps.game;

public class State {
    public boolean check;
    public Piece.Color turn;

    public State(boolean check, Piece.Color turn) {
        this.check = check;
        this.turn = turn;
    }

    public State() {
        this.check = false;
        this.turn = Piece.Color.WHITE;
    }
}
