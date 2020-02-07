package groupName.cps.game;

public class Game {
    public Board board;
    public State state;

    public Game(Board board, State state) {
        this.board = board;
        this.state = state;
    }

    public Game(Board board, boolean check, Piece.Color color) {
        this.board = board;
        this.state = new State(check, color);
    }

    public Game() {
        this.board = new Board();
        this.state = new State();
    }
}
