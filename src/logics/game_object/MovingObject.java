package logics.game_object;

import logics.strategy.movement.Movement;
import utilis.Pair;

/**
 * 
 * Declare the common method for the game_oject that can change their position in
 * the game grid
 *
 */
public interface MovingObject {

	/**
	 * 
	 * @param pos the new object position
	 */
	public void setPos(Pair<Integer, Integer> pos);

	/**
	 * 
	 * @return the movement System of the object
	 */
	public Movement getMovementSystem();
}
