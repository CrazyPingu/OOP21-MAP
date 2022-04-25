package ourTest.oldCode;

/**
 * 
 * This class implements a basic life controller. It's only possible to decrese
 * or increase the life value, remaining in the range from zero to the maximum
 * health value
 *
 */
public class BasicLifeImpl implements BasicLife {

	private int currentHealth;
	private int maxHealth;

	/**
	 * 
	 * @param health    rapresents the starting value of health the entity starts
	 *                  with. Can't be greater than maxHealth
	 * @param maxHealth rapresents the maximum amount of life that can be reached.
	 */
	public BasicLifeImpl(int health, int maxHealth) {
		this.currentHealth = health <= maxHealth ? health : maxHealth;
		this.maxHealth = maxHealth;
	}

	/**
	 * 
	 * @param health rapresents the starting value of health and the maximum amount
	 *               of life that can be reached.
	 */
	public BasicLifeImpl(int health) {
		this.currentHealth = health;
		this.maxHealth = health;
	}

	@Override
	public void takeDamage(int damageValue) {
		this.currentHealth = (this.currentHealth - damageValue) < 0 ? 0 : this.currentHealth - damageValue;
	}

	@Override
	public void heal(int healValue) {
		this.currentHealth = (this.currentHealth + healValue) > maxHealth ? maxHealth : this.currentHealth + healValue;
	}

	@Override
	public int getCurrentHealth() {
		return this.currentHealth;
	}

	@Override
	public int getMaxHealth() {
		return this.maxHealth;
	}

}
