package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.util.*;

public class Plinth extends GamePiece{
	private InteractionResult state;
	private boolean destroyed;
	public Plinth(String label) {
		super('L', label, new Random().nextInt(8 - 1 + 1) + 1);
		state = InteractionResult.NONE;
		this.destroyed = false;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (!this.destroyed && (Math.abs(playerLocation - this.getLocation()) <= 1)) {
			state = InteractionResult.KILL;
		} else {
			state = InteractionResult.NONE;
		}
		return state;
	}
	
	public void setDestroyed(boolean condition) {
		this.destroyed = condition;
	}
	
	public boolean isDestroyed() {
		return this.destroyed;
	}

}
