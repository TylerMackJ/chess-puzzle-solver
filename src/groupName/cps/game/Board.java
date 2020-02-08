package groupName.cps.game;

public class Board {
    public Piece[][] board;

    public Board(Board copy) {
        board = copy.board.clone();
    }

    public Board() {
        board = new Piece[10][10];

        for(int x = 0; x < board[0].length; x++) {
            for(int y = 0; y < board.length; y++) {
                board[y][x] = null;
            }
        }
    }
}
