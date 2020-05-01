# chess-puzzle-solver
ChessPuzzles.com includes games of chess in which the player can force a 
checkmate in either 1, 2, or 3 moves. This project will be used to solve 
these puzzles.

## Getting Started

The following instructions will cover how to download and run a local 
deployment of the our Chess Puzzle Solver with minimal dependencies.

### Prerequisites

You will need to first download the Chess Puzzle Solver repository from 
GitHub. To do so, type the following command in the terminal.

```
https://github.com/TylerMackJ/chess-puzzle-solver.git
```

The API runs on Java JDK 13. So, if you don't have it, download a version 
[here](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html).

### Installing

We do not have any installed packages for our project so it should be a 
"Plug and Play" kind of application.

### Running

To run the Chess Solver, type the following command:

```
mvnw spring-boot:run
```

If everything runs properly, you should see this in your terminal.

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

```

Once the API is up on running, like shown above, you can start making requests
to the different routes that are available

The application is being run on port 8080 so you can view the responses to 
some of the routes in the browser if you go to http://localhost:8080/.

### Routes
* /
* /get_status
* /init_board
* /win_game
* /win_game/init_board
* /win_game/add_piece
* /win_game/delete_board
* /generate_game
* /generate_game/enter_moves
* /generate_game/add_moves
* /generate_game/delete_moves

**/**

Request Type: GET

Expected Input: NONE

Output: Shows a nice little greeting.

```
Welcome to our chess game!
```

**/get_status**

Request Type: GET

Expected Input: NONE

Output: Shows your current status in the game as well as the moves to win
given your current board.

```
Waiting for a board configuration... Send one to http://localhost:8080/init_board
```

**/init_board**

Request Type: POST

Expected Input: PopulateBoard Serialized Object

```
{
    "pieceLocations": "WP33 BP23"
}
```

Output: Returns a serialized version of the same Serialized PopulateBoard
Object with a populated board.

```
{
    "pieceLocations": "WP33 BP23",
    "populatedBoard": [
        [
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ],
        [
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ],
        [
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ],
        [
            null,
            null,
            {
                "type": "PAWN",
                "color": "BLACK"
            },
            {
                "type": "PAWN",
                "color": "WHITE"
            },
            null,
            null,
            null,
            null
        ],
        [
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ],
        [
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ],
        [
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ],
        [
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ]
    ]
}

**/win_game**

Request Type: GET

Expected Input: NONE

Output: Gives you the number of moves to win, or tells you to initialize the board.

**/win_game/add_piece**

Request Type: PUT

Expected Input: A piece, color anc position

Output: 

**/win_game/delete_board**

Request Type: DELETE

Expected Input: NONE

Output: "The board was deleted"

**/generate_game**

Request Type: GET

Expected Input: NONE

Output:

**/generate_game/enter_moves**

Request Type: POST

Expected Input:

Output:

**/generate_game/add_moves**

Request Type: PUT

Expected Input: INTEGER

Output:

**/generate_game/delete_moves**

Request Type: DELETE

Expected Input: NONE

Output: "Number of moves reset to -1" or "You need to post first" if it's not already -1


```
