package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import logics.life.HealLifeSystem;

public class HealLifeSystemTest {
	final private int HEALTH = 9;
	final private int MAX_HEALTH = 10;
	final private int DAMAGE = 1;
	final private int HEAL = 5;

	@Test
	/*
	 * test the correct creation of a HealLifeSystem instantiation.
	 */
	public void createLifeTest() {
		HealLifeSystem life = new HealLifeSystem(this.HEALTH, this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
	}

	@Test
	/*
	 * test the proper operation of the method damage.
	 */
	public void damageTest() {
		HealLifeSystem life = new HealLifeSystem(this.HEALTH, this.MAX_HEALTH);
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
		HealLifeSystem life = new HealLifeSystem(this.HEALTH, this.MAX_HEALTH);
		life.damage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.getCurrentHealth() == 0);
	}

	@Test
	/*
	 * test the correct working of the isDead method
	 */
	public void isDeadTest() {
		HealLifeSystem life = new HealLifeSystem(this.HEALTH, this.MAX_HEALTH);
		assertFalse(life.isDead());
		life.damage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.isDead());
	}

	@Test
	/*
	 * test the correct working of the heal method
	 */
	public void healTest() {
		HealLifeSystem life = new HealLifeSystem(this.MAX_HEALTH, this.MAX_HEALTH);
		life.heal(-this.HEAL);   	//test that heal don't work with negative value
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH);
		life.damage(this.MAX_HEALTH - (this.HEAL - 1));
		life.heal(this.HEAL);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH - 1);
		life.heal(this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH); 
	}
}
