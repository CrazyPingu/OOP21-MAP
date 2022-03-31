package logics.entity.complex_life;

public interface AdvancedLife {
	/**
	 * 
	 * @param damageValue represent the amount of life to decrease.
	 */
	public void takeDamage(int damageValue);

	/**
	 * 
	 * @param healValue represent the amount of life to increase. The health value
	 *                  can't be greater than max health
	 */
	public void heal(int healValue);

	/**
	 * 
	 * @return the current health
	 */
	public int getCurrentHealth();

	/**
	 * 
	 * @return the maximum amount of health that can be reached
	 */
	public int getMaxHealth();

	/**
	 * 
	 * @param shieldValue represent the amount of shield to decrease.
	 */
	public void increaseShield(int shieldValue);

	/**
	 * 
	 * @return the current shield
	 */
	public int getShield();

	/**
	 * 
	 * @return the maximum amount of shield that can be reached
	 */
	public int getMaxShield();
}
