package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;

public class Magician extends GamePiece implements Moveable{
	private InteractionResult state;
	public Magician(String label, int location) {
		super('M', label, location);
		state = InteractionResult.NONE;
	}
	
	// moves the trooper one space closer to the player or one space away from the player
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation > this.getLocation()) {
			this.setLocation(this.getLocation()+1);
		} else {
			this.setLocation(this.getLocation()-1);
		}
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
