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
	//this guy flames you with fire balls if you get too close
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			state = InteractionResult.KILL;
		} else if (Math.abs(this.getLocation()- playerLocation) <=2) {
			state = InteractionResult.HIT;
		}
		else {
			state = InteractionResult.NONE;
		}
		return state;
	}
}
