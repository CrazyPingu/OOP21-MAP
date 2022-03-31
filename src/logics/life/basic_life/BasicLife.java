package logics.life.basic_life;

public interface BasicLife {
	/**
	 * 
	 * @param damageValue represent the amount of life to decrease.
	 */
	public void takeDamage(int damageValue);

	/**
	 * 
	 * @param healValue represent the amount of life to increase. The helth value
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
}
