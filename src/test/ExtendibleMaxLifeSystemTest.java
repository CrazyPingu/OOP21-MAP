package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import logics.life.ExtendibleMaxLifeSystem;

public class ExtendibleMaxLifeSystemTest {
	final private int HEALTH = 9;
	final private int MAX_HEALTH = 10;
	final private int MAX_HEALTH_EXTENSION = 15;
	final private int DAMAGE = 1;
	final private int HEAL = 5;

	@Test
	/*
	 * test the correct creation of a HealLifeSystem instantiation.
	 */
	public void createLifeTest() {
		ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH,
				this.MAX_HEALTH_EXTENSION);
		assertTrue(life.getCurrentHealth() == this.HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);

		// test than the LifeSystem can't be created with a starting life value greater
		// tha maxHealth value
		life = new ExtendibleMaxLifeSystem(this.MAX_HEALTH + 1, this.MAX_HEALTH, this.MAX_HEALTH_EXTENSION);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);

		// test than the LifeSystem can't be created with a maximum Health value greater
		// tha maxHealthExtension value
		life = new ExtendibleMaxLifeSystem(this.MAX_HEALTH, this.MAX_HEALTH_EXTENSION + 1, this.MAX_HEALTH_EXTENSION);
		assertTrue(life.getMaxHealthReachable() == this.MAX_HEALTH_EXTENSION);

	}

	@Test
	/*
	 * test the proper operation of the method damage.
	 */
	public void damageTest() {
		ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH,
				this.MAX_HEALTH_EXTENSION);
		life.damage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.HEALTH - this.DAMAGE);
		life.damage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.HEALTH - (2 * this.DAMAGE));
	}

	@Test
	/*
	 * test that the health value does not go below zero
	 */
	public void healthNotBelowZeroTest() {
		ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH,
				this.MAX_HEALTH_EXTENSION);
		life.damage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.getCurrentHealth() == 0);
	}

	@Test
	/*
	 * test the correct working of the isDead method
	 */
	public void isDeadTest() {
		ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH,
				this.MAX_HEALTH_EXTENSION);
		assertFalse(life.isDead());
		life.damage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.isDead());
	}

	@Test
	/*
	 * test the correct working of the heal method
	 */
	public void healTest() {
		ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(this.MAX_HEALTH, this.MAX_HEALTH,
				this.MAX_HEALTH_EXTENSION);
		// test that heal don't work with negative value
		life.heal(-this.HEAL);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH);
		life.damage(this.MAX_HEALTH - (this.HEAL - 1));
		life.heal(this.HEAL);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH - 1);
		life.heal(this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH);
	}

	@Test
	/*
	 * test the correct working of the heal method
	 */
	public void increaseMaxHealthTest() {
		ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH,
				this.MAX_HEALTH_EXTENSION);

		life.setMaxHealth(this.MAX_HEALTH + 1);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH + 1);

		life.setMaxHealth(this.MAX_HEALTH + 2);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH + 2);

		life.setMaxHealth(this.MAX_HEALTH - 5);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH - 5);
		
		life.setMaxHealth(this.MAX_HEALTH_EXTENSION + 1);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH_EXTENSION);

		int currentMaxHealth = life.getMaxHealth();
		life.setMaxHealth(0);
		assertTrue(life.getMaxHealth() == currentMaxHealth);

	}

}
