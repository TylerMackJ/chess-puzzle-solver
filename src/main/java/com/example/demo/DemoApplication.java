
package com.example.demo;
import groupName.cps.game.BruteForce.BruteForce;
import groupName.cps.game.Game;
import groupName.cps.game.Movement.Movement;
import groupName.cps.game.Rest.PieceLocation;
import groupName.cps.game.Rest.MoveCount;
import org.springframework.boot.SpringApplication;
import groupName.cps.game.GenerateGame.GenerateGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.PostRequest;
import javax.validation.Valid;
import groupName.cps.game.PopulateBoard;
import groupName.cps.game.Piece;
import groupName.cps.game.Movement.Move;

import java.util.Arrays;
import java.util.LinkedList;

@SpringBootApplication
@RestController
public class DemoApplication {

	int moveCount = -1;
	String name;
	Game gameInstance;
	Piece[][] board;
	LinkedList<Move> winningMoves;

	GenerateGame generateInstance;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*Example GET Requests*/
	@GetMapping("/")
	public String index() {
		return "Welcome to our chess game!";
	}

//	@GetMapping("/hello")
//	public String hello() {
//		return String.format("Hello %s!", this.name);
//	}

	/*Example Post Request*/
//	@PostMapping(path = "/members", consumes = "application/json")
//	public void setName(@RequestBody() PostRequest request) {
//		this.name = request.getBody();
//	}

	//GET moves to win
	@GetMapping("/win_game")
	public String getStatus() {
		if(this.gameInstance == null) {
			return "Waiting for a board configuration... Send one to http://localhost:8080/win_game/init_board";
		}
		if(this.gameInstance == null) {
			this.gameInstance = new Game(this.board);
		}
		if(this.winningMoves == null) {
			this.winningMoves = Movement.getMoves(this.gameInstance);
		}

		int i = 1;
		while(!BruteForce.win(this.gameInstance, i)) {i++;}

		StringBuilder movesToWin = new StringBuilder();
		for(Move mv : BruteForce.solvePuzzle(this.gameInstance, i))
			movesToWin.append(mv.toString() + "\n");

		return movesToWin.toString();
	}

	//POST new board
	@PostMapping(path="/win_game/init_board", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PopulateBoard> setBoard(@RequestBody() PopulateBoard newBoard) {

		this.board = newBoard.getPopulatedBoard();
		this.gameInstance = new Game(this.board);

		return new ResponseEntity<PopulateBoard>(newBoard, HttpStatus.OK);
	}

	@PutMapping(path="/win_game/add_piece", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Piece[][]> putBoard(@Valid @RequestBody PieceLocation pieceLocation) {
		if(this.gameInstance != null) {
			this.gameInstance.board[pieceLocation.getLocation()[0]][pieceLocation.getLocation()[1]] = pieceLocation.getPiece();
			return new ResponseEntity<Piece[][]>(this.gameInstance.board, HttpStatus.OK);
		} else {
			return new ResponseEntity<Piece[][]>(new Piece[0][0], HttpStatus.FAILED_DEPENDENCY);
		}
	}

	@DeleteMapping("/win_game/delete_board")
	public String deleteBoard() {
		this.gameInstance = null;

		return "The board was deleted!";
	}





//Generate Game
//the get service should be telling you how to post the number of moves or it should return the generated game


	//GET
	@GetMapping("/generate_game")
	public String getInfo() {
		if(this.moveCount == -1) {
			return "To see on how to post the number of moves, go to this link:http://localhost:8080/generate_game/enter_moves ";
		}
		return Integer.toString(this.moveCount);

	}

	//POST new board
	@PostMapping(path="/generate_game/enter_moves", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Integer> setBoard(@RequestBody() MoveCount mc) {

		if(this.moveCount == -1) {
			this.moveCount = mc.moveCount;
			return new ResponseEntity<Integer>(mc.moveCount, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Integer>(mc.moveCount, HttpStatus.FAILED_DEPENDENCY);
		}
	}


}