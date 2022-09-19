package levelPieces;

import gameEngine.Drawable;
import java.util.ArrayList;
import gameEngine.Moveable;
import levelPieces.GamePiece;
import java.util.*;

public class LevelSetup {
	
	private static final int boardSize = 10;
	private Drawable[] board = new Drawable[boardSize];
	ArrayList<GamePiece> pieces= new ArrayList<GamePiece>();
	ArrayList<Moveable> moveables= new ArrayList<Moveable>();
	
	public LevelSetup() {
		
	}
	
	public void createLevel(int levelNum) {
		
		// Prints out the legend for ease of use
		System.out.println("Level " + levelNum + " Legend:");
		System.out.println("P - Player");
		System.out.println("H - Healer");
		System.out.println("M - Magician");
		System.out.println("T - Trooper");
		System.out.println("S - Supreme Leader");
		System.out.println("L - Plinth");
		System.out.println();
		
		switch (levelNum) {
			case 1:
				pieces.add(new Trooper("Dave", new Random().nextInt(3-2+1)+2));
				pieces.add(new Plinth("David"));
				pieces.add(new SupremeLeader("Daverino", 9));
				this.updateBoard();
				break;
			case 2:
				System.out.println("Level 2");
				break;
			default: 
				System.out.println("Ayudame");
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
		for(int i=0; i<boardSize; i++) {
			board[i] = null;
		}
		for(GamePiece gamePiece: pieces) {
			board[gamePiece.getLocation()] = gamePiece;
		}
	}

}
