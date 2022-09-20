package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.GamePiece;
import gameEngine.Moveable;

public class PlinthDemolitionTeam extends GamePiece implements Moveable{
	private InteractionResult state;
	private Plinth target;
	public PlinthDemolitionTeam(String label, int location, Plinth target) {
		super('D', label, location);
		state = InteractionResult.NONE;
		this.target = target;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[this.getLocation()] = null;
		if(this.target.getLocation() > this.getLocation()) {
			this.setLocation(this.getLocation()+1);
		} else {
			this.setLocation(this.getLocation()-1);
		}
		gameBoard[this.getLocation()] = this;
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.target.getLocation() == this.getLocation()) {
			state = InteractionResult.NONE;
			this.target.setDestroyed(true);
		} else {
			state = InteractionResult.NONE;
		}
		return state;
	}

	
}
