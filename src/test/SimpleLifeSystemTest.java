package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import logics.life.SimpleLifeSystem;

public class SimpleLifeSystemTest {
	final private int HEALTH = 9;
	final private int DAMAGE = 1;

	@Test
	/*
	 * test the correct creation of a SimpleLifeSystem instantiation.
	 */
	public void createLifeTest() {
		SimpleLifeSystem life = new SimpleLifeSystem(this.HEALTH);
		assertTrue(life.getCurrentHealth() == this.HEALTH);
	}

	@Test
	/*
	 * test the proper operation of the method damage.
	 */
	public void damageTest() {
		SimpleLifeSystem life = new SimpleLifeSystem(this.HEALTH);
		life.damage(-this.DAMAGE); 		//test that damage don't work with negative value
		assertTrue(life.getCurrentHealth() == this.HEALTH);
		life.damage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.HEALTH - this.DAMAGE);
		life.damage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.HEALTH - (2*this.DAMAGE));
	}

	@Test
	/*
	 * test that the health value does not go below zero
	 */
	public void healthNotBelowZeroTest() {
		SimpleLifeSystem life = new SimpleLifeSystem(this.HEALTH);
		life.damage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.getCurrentHealth() == 0);
	}
	
	@Test
	/*
	 * test the correct working of the isDead method 
	 */
	public void isDeadTest() { 
		SimpleLifeSystem life = new SimpleLifeSystem(this.HEALTH);
		assertFalse(life.isDead());
		life.damage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.isDead());
		
	}
}
