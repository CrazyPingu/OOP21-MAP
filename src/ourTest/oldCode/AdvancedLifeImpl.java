package ourTest.oldCode;

/**
 * 
 * This class implements an advanced life controller. It's possible to: 
 * - decrese or increase the life value, remaining in the range from zero to the
 * maximum health value 
 * - modify the maximum health value, in the range from 1 to the
 *  limit specified in the constructor
 */
public class AdvancedLifeImpl implements AdvancedLife {

	BasicLife life;
	private int maxHealthLimit;

	/**
	 * 
	 * @param health         represents the value the entity start with. This
	 *                       parameter can't be grater than maxHealth.
	 * @param maxHealth      rapresents the maximum value of life that the entity
	 *                       can currently reach.
	 * @param maxHealthLimit rapresents the maximum value maxHealth can reach.
	 */
	public AdvancedLifeImpl(int health, int maxHealth, int maxHealthLimit) {
		life = new BasicLifeImpl(health, maxHealth);
		this.maxHealthLimit = maxHealthLimit;
	}

	@Override
	public void takeDamage(int damageValue) {
		life.takeDamage(damageValue);
	}

	@Override
	public void heal(int healValue) {
		life.heal(healValue);
	}

	@Override
	public int getCurrentHealth() {
		return life.getCurrentHealth();
	}

	@Override
	public int getMaxHealth() {
		return life.getMaxHealth();
	}

	@Override
	public void upgradeMaxHealth(int maxHealthValue) {
		if (maxHealthValue >= 1) {
			if (maxHealthValue <= this.maxHealthLimit) {
				life = new BasicLifeImpl(life.getCurrentHealth(), maxHealthValue);
			} else {
				life = new BasicLifeImpl(life.getCurrentHealth(), maxHealthLimit);
			}
		}
	}

	@Override
	public int getMaxHealthLimit() {
		return this.maxHealthLimit;
	}

}
