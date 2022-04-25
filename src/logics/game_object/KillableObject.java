package logics.game_object;

/**
 * 
 * Declare the common method for the game_object that can take damage and die
 *
 */
public interface KillableObject {
	/**
	 * @param damageValue value that will be decreased from the entity's current
	 *                    health.
	 */
	public void damage(int damageValue);

	/**
	 * 
	 * @return the life state of the entity (True = DEAD, FALSE = IN LIFE)
	 */
	public Boolean isDead();
}
