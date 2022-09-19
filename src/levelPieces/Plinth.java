package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.util.*;

public class Plinth extends GamePiece{
	private InteractionResult state;
	public Plinth(String label) {
		super('L', label, new Random().nextInt(8 - 1 + 1) + 1);
		state = InteractionResult.NONE;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(playerLocation - this.getLocation()) <= 1) {
			state = InteractionResult.KILL;
		} else {
			state = InteractionResult.NONE;
		}
		return state;
	}

}
