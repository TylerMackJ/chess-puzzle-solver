
package com.example.demo;
import groupName.cps.game.Game;
import groupName.cps.game.Movement.Movement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.PostRequest;
import groupName.cps.game.PopulateBoard;
import groupName.cps.game.Piece;
import groupName.cps.game.Movement.Move;

import java.util.Arrays;
import java.util.LinkedList;

@SpringBootApplication
@RestController
public class DemoApplication {

	String name;
	Game gameInstance;
	Piece[][] board;
	LinkedList<Move> winningMoves;

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
	@GetMapping("/get_status")
	public String getStatus() {
		if(this.board == null) {
			return "Waiting for a board configuration... Send one to http://localhost:8080/init_board";
		}
		if(this.gameInstance == null) {
			this.gameInstance = new Game(this.board);
		}
		if(this.winningMoves == null) {
			this.winningMoves = Movement.getMoves(this.gameInstance);
		}

		return "We doin Aight.";
	}

	//POST new board
	@PostMapping(path="/init_board", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PopulateBoard> setBoard(@RequestBody() PopulateBoard newBoard) {

		this.board = newBoard.getPopulatedBoard();
		this.gameInstance = new Game(this.board);

		return new ResponseEntity<PopulateBoard>(newBoard, HttpStatus.OK);
	}
}
            