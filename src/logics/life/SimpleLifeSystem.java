package logics.life;

/**
 * 
 * this class models a Life System that can only take damage
 *
 */
public class SimpleLifeSystem implements LifeSystem {

	private int health; 
	
	public SimpleLifeSystem(int health) {
		this.health = health; 
	}
	
	@Override
	public int getCurrentHealth() {
		return this.health;
	}

	@Override
	public void damage(int damageValue) {
		this.health = (this.health - damageValue) < 0 ? 0 : this.health - damageValue;
	}

	@Override
	public Boolean isDead() {
		return !(this.health > 0);
	}

}
