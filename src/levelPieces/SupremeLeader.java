package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;

public class SupremeLeader extends GamePiece implements Moveable{
	private InteractionResult state;
	public SupremeLeader(String label, int location) {
		super('S', label, location);
		state = InteractionResult.NONE;
	}
	
	// moves the trooper one space closer to the player or one space away from the player
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == 0) {
			this.setLocation(gameBoard.length-1);
		} else {
			this.setLocation(0);
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(playerLocation - this.getLocation()) <= 2) {
			state = InteractionResult.HIT;
		} else {
			state = InteractionResult.NONE;
		}
		return state;
	}
}
