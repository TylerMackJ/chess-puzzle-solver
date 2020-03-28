package groupName.cps.game;

public class PopulateBoard {
    public Piece[][] board;
    public String pieceLocations;


    public PopulateBoard(String pieceLocations) {
        this.board = new Piece[8][8];
        for(int x = 0; x < board[0].length; x++) {
            for(int y = 0; y < board.length; y++) {
                board[y][x] = null;
            }
        }

        this.pieceLocations = pieceLocations;
    }

    public Piece[][] getPopulatedBoard() {
        // Separate the pieceLocations String into a String array
        String[] locationArray = this.pieceLocations.split(" ");
        Piece.Color currentColor = null;
        Piece.Type currentType = null;
        int currentX = 0;
        int currentY = 0;

        for (int lcv=0; lcv<locationArray.length; lcv++) {
            // Separate the element into a character array
            char[] currentCharacters = locationArray[lcv].toCharArray();

            // Determine what the color is
            switch (currentCharacters[0]){
                case 'W': currentColor = Piece.Color.WHITE;
                break;
                case 'B': currentColor = Piece.Color.BLACK;
                break;
            }

            // Determine what the piece type is
            switch (currentCharacters[1]){
                case 'K': currentType = Piece.Type.KING;
                break;
                case 'Q': currentType = Piece.Type.QUEEN;
                break;
                case 'k': currentType = Piece.Type.KNIGHT;
                break;
                case 'B': currentType = Piece.Type.BISHOP;
                break;
                case 'R': currentType = Piece.Type.ROOK;
                break;
                case 'P': currentType = Piece.Type.PAWN;
                break;
            }

            // Create the Piece object
            Piece currentPiece = new Piece(currentType, currentColor);

            // Get the X value
            //int a=Integer.parseInt(String.valueOf(c));
            currentX =  Integer.parseInt(String.valueOf(currentCharacters[2]));

            // Get the Y value
            currentY =  Integer.parseInt(String.valueOf(currentCharacters[3]));

            // Place the piece in the desired location on the board
            this.board[currentY][currentX] = currentPiece;
        }

        return this.board;
    }
}

