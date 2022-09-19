package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.GamePiece;

public class Healer extends GamePiece{
	private InteractionResult state;
	public Healer(String label, int location) {
		super('H', label, location);
		state = InteractionResult.NONE;
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
