package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;

import java.util.ArrayList;
import gameEngine.Moveable;
import java.util.*;

public class LevelSetup {
	
	private Drawable[] board = new Drawable[GameEngine.BOARD_SIZE];
	ArrayList<GamePiece> pieces= new ArrayList<GamePiece>();
	ArrayList<Moveable> moveables= new ArrayList<Moveable>();
	
	public LevelSetup() {
		
	}
	
	public void createLevel(int levelNum) {

		switch (levelNum) {
			case 1:
				System.out.println("Level " + levelNum + " Legend:");
				Plinth p = new Plinth("Plinth");
				PlinthDemolitionTeam pdt = new PlinthDemolitionTeam("Plinth Demolition Team", GameEngine.BOARD_SIZE - 2, p);
				Trooper t = new Trooper("Trooper", new Random().nextInt(GameEngine.BOARD_SIZE-2 - GameEngine.BOARD_SIZE/2 +1) + GameEngine.BOARD_SIZE/2);
				
				pieces.add(t);
				moveables.add(t);
				pieces.add(p);
				pieces.add(pdt);
				moveables.add(pdt);
				
				// Prints out the legend for ease of use
				this.updateBoard();
				for (GamePiece piece: pieces) {
					System.out.println(piece);
				}
				System.out.println();
				break;
			case 2:
				pieces.add(new Trooper("Dave", new Random().nextInt(GameEngine.BOARD_SIZE-2 - GameEngine.BOARD_SIZE/2 +1) + GameEngine.BOARD_SIZE/2));
				pieces.add(new Plinth("David"));
				pieces.add(new SupremeLeader("Daverino", GameEngine.BOARD_SIZE-1));
				this.updateBoard();
				break;
			default: 
				pieces.add(new Trooper("Dave", new Random().nextInt(GameEngine.BOARD_SIZE-2 - GameEngine.BOARD_SIZE/2 +1) + GameEngine.BOARD_SIZE/2));
				pieces.add(new Plinth("David"));
				pieces.add(new SupremeLeader("Daverino", GameEngine.BOARD_SIZE-1));
				this.updateBoard();
				break;
		}
		
	}

	public Drawable[] getBoard() {
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		return moveables;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return pieces;
	}

	public int getPlayerStartLoc() {
		return 0;
	}
	
	public void updateBoard() {
		for(int i=0; i<GameEngine.BOARD_SIZE; i++) {
			board[i] = null;
		}
		for(GamePiece gamePiece: pieces) {
			board[gamePiece.getLocation()] = gamePiece;
		}
	}

}
