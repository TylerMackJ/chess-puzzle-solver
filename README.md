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
* /win_game
* /generate_game

**/**

Request Type: GET

Expected Input: NONE

Output: Shows a nice little greeting.

**GET /win_game**

Expected Input: NONE

Output: Moves to win a puzzle, or a message saying to POST first.

**POST /win_game**

Expected Input: 

```json
{
  "pieceLocations": "BQ30 WP22 WP04 WB44 WK54 BP74 BK75 WR26"
}
```

You can change the "BQ30 WP22 WP04 WB44 WK54 BP74 BK75 WR26" to which ever puzzle you would like to solve.

Output: A JSON representation of the resultant board.

**PUT /win_game**

Expected Input:

```json
{
    "pieceString": "WQ24"
}
```

You can change "WQ24" to which location you would like to add the piece to.

Output: A JSON representation of the resultant board with the new piece added.

**DELETE /win_game**

Expected Input: NONE

Output: A message verifying the board was deleted.

**GET /generate_game**

Expected Input: NONE

Output: The generated game or, a message saying to POST first.

**POST /generate_game**

Expected Input: 

```json
{
  "moveCount": 2
}
```

You can change the 2 to which ever number of moves you want.

Output: A response of the moveCount to verify it was set.

**PUT /generate_game**

Expected Input:

```json
{
  "moveCount": 2
}
```

You can change the 2 to which ever number of moves you want.

Output: A response of the updated moveCount to verify it was updated.

**DELETE /generate_game**

Expected Input: NONE

Output: A message verifying the moveCount was reset to -1.