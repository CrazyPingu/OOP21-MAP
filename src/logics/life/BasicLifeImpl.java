package logics.life;

public class BasicLifeImpl implements BasicLife {

	private int currentHealth; 
	private int maxHealth;
	
	public BasicLifeImpl(int health, int maxHealth) {
		this.currentHealth = health; 
		this.maxHealth = maxHealth; 
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
