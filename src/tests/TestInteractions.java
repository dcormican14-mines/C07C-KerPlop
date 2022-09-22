package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import gameEngine.*;
import levelPieces.*;

public class TestInteractions {
	@Test
	public void testMagicianInteract() {
		// spawn mage next to player, see how reacts
//		assertEquals(InteractionResult.HIT, mage.interact(gameBoard, playerLocation))
		
		// spawn mage on player, see how reacts
	}
	
	@Test
	public void testPlinthInteract() {
		Plinth p = new Plinth("Plinth");
		Player badPlayer = new Player(p.getLocation()-1);
		Player goodPlayer = new Player(p.getLocation()+2);
		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[p.getLocation()] = p;
		gameBoard[goodPlayer.getLocation()] = goodPlayer;
		gameBoard[badPlayer.getLocation()] = badPlayer;
		
		assertEquals(InteractionResult.KILL, p.interact(gameBoard, badPlayer.getLocation()));
		assertEquals(InteractionResult.NONE, p.interact(gameBoard, goodPlayer.getLocation()));
	}
	
	@Test
	public void testPlinthDemolitionTeamInteract() {
		
		// testing to see if plinth demolition team destroyed plinths correctly
		Plinth p = new Plinth("Plinth");
		Plinth p2 = new Plinth("Plinth2");
		PlinthDemolitionTeam pdt = new PlinthDemolitionTeam("Plinth Demo Team", p.getLocation(), p);
		PlinthDemolitionTeam pdt2 = new PlinthDemolitionTeam("Plinth Demo Team 2", p2.getLocation() + 1, p2);

		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[p.getLocation()] = p;
		gameBoard[p2.getLocation()] = p2;
		gameBoard[pdt.getLocation()] = pdt;
		gameBoard[pdt2.getLocation()] = pdt2;
		
		pdt.interact(gameBoard, 0);
		assertEquals(true, p.isDestroyed());
		assertEquals(false, p2.isDestroyed());
		
		pdt2.interact(gameBoard, 0);
		assertEquals(false, p2.isDestroyed());
		
		pdt2.move(gameBoard, 0);
		assertEquals(false, p2.isDestroyed());
		
		pdt2.interact(gameBoard, 0);
		assertEquals(true, p2.isDestroyed());

	}
}
