package logics.life;

public class ExtendibleMaxLifeSystem implements LifeSystem, HealSystem {

	private HealLifeSystem life;
	private int maxHealthReachable;

	/**
	 * 
	 * @param startingLife       is the amount of health the system start with
	 * @param maxHealth          the maximum amount of health that can be reached
	 *                           using heal method
	 * @param maxHealthReachable represent the maximum extension value for the
	 *                           health
	 */
	public ExtendibleMaxLifeSystem(int startingLife, int maxHealth, int maxHealthReachable) {
		maxHealth = maxHealth <= maxHealthReachable ? maxHealth : maxHealthReachable;
		this.life = new HealLifeSystem(startingLife, maxHealth);
		this.maxHealthReachable = maxHealthReachable;
	}

	/**
	 * 
	 * @param maxLifeExtension represent the new maximum amount of health the system
	 *                         can reach. It has to be greater than zero and less
	 *                         than maxHealthExtension value that is specified in
	 *                         the constructor
	 */
	public void setMaxHealth(int lifeExtension) {
		if (lifeExtension > 0 && (lifeExtension <= this.maxHealthReachable)) {
			int newStartingLifeValue = this.life.getCurrentHealth() <= lifeExtension ? this.life.getCurrentHealth()
					: lifeExtension;
			this.life = new HealLifeSystem(newStartingLifeValue, lifeExtension);
		}
	}

	/**
	 * 
	 * @return the current maximum amounth of health the sistem can reach using the
	 *         heal method
	 */
	public int getMaxHealthReachable() {
		return this.maxHealthReachable;
	}

	@Override
	public int getCurrentHealth() {
		return this.life.getCurrentHealth();
	}

	@Override
	public void damage(int damageValue) {
		this.life.damage(damageValue);

	}

	@Override
	public Boolean isDead() {
		return this.life.isDead();
	}

	@Override
	public void heal(int healValue) {
		this.life.heal(healValue);

	}

	@Override
	public int getMaxHealth() {
		return this.life.getMaxHealth();
	}

}
