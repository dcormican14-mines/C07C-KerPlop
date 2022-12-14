package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;

public class Trooper extends GamePiece implements Moveable{
	private InteractionResult state;
	public Trooper(String label, int location) {
		super('T', label, location);
		state = InteractionResult.NONE;
	}
	
	// moves the trooper one space closer to the player or one space away from the player
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[this.getLocation()] = null;
		if (playerLocation > this.getLocation()) {
			this.setLocation(this.getLocation()+1);
		} else {
			this.setLocation(this.getLocation()-1);
		}
		gameBoard[this.getLocation()] = this;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			state = InteractionResult.HIT;
		} else {
			state = InteractionResult.NONE;
		}
		return state;
	}
}
