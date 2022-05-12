package logics.game_object;

import logics.strategy.movement.Movement;
import utilities.Pair;

/**
 * 
 * Declare the common method for the game_oject that can change their position in
 * the game grid
 *
 */
public interface MovingObject {

	/**
	 * 
	 * @param pos the new game object position
	 */
	public void setPos(Pair<Integer, Integer> pos);
	
	/**
	 * 
	 * @return the current game object position
	 */
	public Pair<Integer, Integer> getPos(); 

	/**
	 * 
	 * @return the movement System of the game object
	 */
	public Movement getMovementSystem();
}
