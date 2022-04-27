package logics.strategy.movement;

/**
 * 
 * Interface that declares methods for the Movement Factory. Each method returns
 * a different type of movement.
 * 
 */
public interface MovementFactory {

	/**
	 * 
	 * @return a MovementImpl that allow an an entity to move only in the adiacents
	 *         cells
	 */
	public MovementImpl stepMovement();

	/**
	 * 
	 * @return a MovementImpl that allow an entity to move in a "+" shape cells with
	 *         a distance of 1 from his current position.
	 */
	public MovementImpl runMovement();
}
