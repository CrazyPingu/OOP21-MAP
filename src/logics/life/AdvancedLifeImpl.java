package logics.life;

public class AdvancedLifeImpl implements AdvancedLife {

	BasicLife life; 
	private int maxHealthLimit; 
	
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
		if(maxHealthValue <= this.maxHealthLimit) { 
			life = new BasicLifeImpl(life.getCurrentHealth(), maxHealthValue);				
		}else { 
			life = new BasicLifeImpl(life.getCurrentHealth(), maxHealthLimit);
		}
	}

}
