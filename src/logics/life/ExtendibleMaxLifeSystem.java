package logics.life;

public class ExtendibleMaxLifeSystem implements LifeSystem {

	private HealLifeSystem life; 
	private int maxHealthExtension; 
	
	public ExtendibleMaxLifeSystem(int startingLife, int maxHealth, int maxHealthExtension) {
		this.life = new HealLifeSystem(startingLife, maxHealth); 
		this.maxHealthExtension = maxHealthExtension;
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

}
