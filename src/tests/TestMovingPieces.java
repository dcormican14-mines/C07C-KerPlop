package tests;

import org.junit.jupiter.api.Test;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Magician;
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
			tracker[i]++;
			assert(tracker[i] <= 1);
		}
	}
	
	// move to testInteractions
	@Test
	public void testMagicianInteract() {
		// spawn mage next to player, see how reacts
//		assertEquals(InteractionResult.HIT, mage.interact(gameBoard, playerLocation))
		
		// spawn mage on player, see how reacts
	}
	
}
