package levelPieces;

import gameEngine.Drawable;
import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	
	private static final int boardSize = 4;
	private Drawable[] board = new Drawable[boardSize];
	
	public LevelSetup() {
		
	}
	public void createLevel(int levelNum) {
		switch (levelNum) {
			case 0:
				System.out.println("Level 0");
			case 1:
				System.out.println("Level 1");
			case 2:
				System.out.println("Level 2");
			case 3:
				System.out.println("Level 3");
			default: 
				System.out.println("Ayudame");
		}
		
	}

	public Drawable[] getBoard() {
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return 0;
	}

}
