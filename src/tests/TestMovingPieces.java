package tests;

import org.junit.jupiter.api.Test;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Magician;
import levelPieces.Plinth;
import levelPieces.PlinthDemolitionTeam;
import levelPieces.Trooper;
import levelPieces.SupremeLeader;
import gameEngine.Player;

public class TestMovingPieces {
	@Test
	public void testMagicianMove() {
		// Magician starts at the far right side of the board.
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Magician mage = new Magician("Magician", GameEngine.BOARD_SIZE-1);
		gameBoard[mage.getLocation()] = mage;
		
		// Player starts at the far left side of the board.
		Player newPlayer = new Player(0);
		gameBoard[newPlayer.getLocation()] = newPlayer;
		
		// If the player doesn't move, the magician should hit each space once and only once
		int[] tracker = new int[GameEngine.BOARD_SIZE];
		for (int i=0; i<GameEngine.BOARD_SIZE; i++) {
			mage.move(gameBoard, newPlayer.getLocation());
			if (gameBoard[i] == mage) {
				tracker[i]++;
			}
			assert(tracker[i] <= 1);
		}
	}
	
	@Test
	public void testTrooperMove() {
		// Trooper starts at the far right side of the board.
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Trooper t = new Trooper("Trooper", GameEngine.BOARD_SIZE-1);
		gameBoard[t.getLocation()] = t;
		
		// Player starts at the far left side of the board.
		Player newPlayer = new Player(0);
		gameBoard[newPlayer.getLocation()] = newPlayer;
		
		// If the player doesn't move, the trooper should hit each space once and only once
		int[] tracker = new int[GameEngine.BOARD_SIZE];
		for (int i=0; i<GameEngine.BOARD_SIZE; i++) {
			t.move(gameBoard, newPlayer.getLocation());
			if (gameBoard[i] == t) {
				tracker[i]++;
			}
			assert(tracker[i] <= 1);
		}
	}
	
	@Test
	public void testSupremeLeaderMove() {
		// SupremeLeader starts at the far right side of the board.
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		SupremeLeader sl = new SupremeLeader("SupremeLeader", GameEngine.BOARD_SIZE-1);
		gameBoard[sl.getLocation()] = sl;
		
		// The Supreme leader should go between the left and right side an equal amount of times.
		for (int i=0; i<200; i++) {
			sl.move(gameBoard, 0);
			// If the supreme leader is not in either end, something is wrong
			assert (sl.getLocation() == 0 || sl.getLocation() == GameEngine.BOARD_SIZE-1);
		}
	}
	
	@Test
	public void testPlinthDemolitionTeamMove() {
		// Plinth starts on the board in a random location and the demo team starts in a random location to the right of it.
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Plinth p = new Plinth("Plinth");
		PlinthDemolitionTeam pdt = new PlinthDemolitionTeam("Plinth Demo Team", GameEngine.BOARD_SIZE-1, p);
		gameBoard[p.getLocation()] = p;
		gameBoard[pdt.getLocation()] = pdt;
		
		// The Plinth Demo Team should always move towards the Plinth, and it will never move more than one space past the plinth.
		int maxLoc = pdt.getLocation();
		int minLoc = p.getLocation()-1;
		for (int i=0; i<200; i++) {
			pdt.move(gameBoard, 0);
			// Checks to see if the demo team is out of bounds.
			assert(minLoc <= pdt.getLocation());
			assert(pdt.getLocation() <= maxLoc);
		}
	}
}
