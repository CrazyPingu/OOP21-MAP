package logics.life;

public class HealLifeSystem implements LifeSystem {

	private SimpleLifeSystem life;
	private int maxHealth;

	/**
	 * 
	 * @param startingLife is the amount of health the system start with
	 * @param maxHealth    the maximum amount of health that can be reached using
	 *                     heal method
	 */
	public HealLifeSystem(int startingLife, int maxHealth) {
		this.life = new SimpleLifeSystem(startingLife);
		this.maxHealth = maxHealth;
	}

	/**
	 * 
	 * @param healValue represent the amount of life to increase. The helth value
	 *                  can't be greater than max health
	 */
	public void heal(int healValue) {
		int newHealthValue = (this.life.getCurrentHealth() + healValue) > maxHealth ? maxHealth
				: this.life.getCurrentHealth() + healValue;
		this.life = new SimpleLifeSystem(newHealthValue);
	}
	
	/**
	 * 
	 * @return the maximum amount of health that can be reached
	 */
	public int getMaxHealth() {
		return this.maxHealth; 
		
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
		return this.isDead();
	}

}
