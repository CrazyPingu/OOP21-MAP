package logics.life;

public class ExtendibleMaxLifeSystem implements LifeSystem, HealSystem {

	private HealLifeSystem life;
	private int maxHealthExtension;

	/**
	 * 
	 * @param startingLife       is the amount of health the system start with
	 * @param maxHealth          the maximum amount of health that can be reached
	 *                           using heal method
	 * @param maxHealthExtension represent the maximum extension value for the
	 *                           health
	 */
	public ExtendibleMaxLifeSystem(int startingLife, int maxHealth, int maxHealthExtension) {
		this.life = new HealLifeSystem(startingLife, maxHealth);
		this.maxHealthExtension = maxHealthExtension;
	}

	/**
	 * 
	 * @param maxLifeExtension represent the new maximum amount of health the system
	 *                         can reach
	 */
	public void extendMaxLife(int lifeExtension) {
		if (lifeExtension > 0 && (lifeExtension <= this.maxHealthExtension)) {
			int newStartingLifeValue = this.life.getCurrentHealth() <= lifeExtension ? this.life.getCurrentHealth()
					: lifeExtension;
			this.life = new HealLifeSystem(newStartingLifeValue, lifeExtension);
		}
	}
	
	/**
	 * 
	 * @return the current maximum amounth of health the sistem can reach using the heal method
	 */
	public int getCurrentmaxHealth() { 
		return this.life.getMaxHealth(); 
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
