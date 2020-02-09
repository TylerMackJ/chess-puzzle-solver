package groupName.cps.game;

public class Game {
    public Piece[][] board;
    public State state;

    public Game(Piece[][] clone, State state) {
        this.board = clone.clone();
        this.state = state;
    }

    public Game(Piece[][] clone, boolean check, Piece.Color color) {
        this.board = clone.clone();
        this.state = new State(check, color);
    }

    public Game() {
        this.board = new Piece[8][8];
        this.state = new State();

        for(int x = 0; x < board[0].length; x++) {
            for(int y = 0; y < board.length; y++) {
                board[y][x] = null;
            }
        }
    }
}
