package model.life_system;

/**
 * 
 * This class declare all the common method for a Life System implementation
 *
 */
public interface LifeSystem {

	/**
	 * 
	 * @return the current health
	 */
	int getCurrentHealth();

	/**
	 * 
	 * @param damageValue represent the value to decrese from the current health.
	 *                    Don't work with negative values
	 */
	void damage(int damageValue);

	/**
	 * 
	 * @return the life state of the entity (True = DEAD, FALSE = IN LIFE)
	 */
	Boolean isDead();
}
