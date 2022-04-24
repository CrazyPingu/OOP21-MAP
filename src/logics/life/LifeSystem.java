package logics.life;

/**
 * 
 * this class declare all the common method for a Life System implementation
 *
 */
public interface LifeSystem {

	/**
	 * 
	 * @return the current health
	 */
	public int getCurrentHealth();

	/**
	 * 
	 * @param damageValue represent the value to decrese from the current health.
	 *                    Don't work with negative values
	 */
	public void damage(int damageValue);

	/**
	 * 
	 * @return the life state of the entity (True = DEAD, FALSE = IN LIFE)
	 */
	public Boolean isDead();
}
