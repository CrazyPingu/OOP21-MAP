package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import ourTest.oldCode.BasicLife;
import ourTest.oldCode.BasicLifeImpl;

public class BasicLifeTest {
	
	final private int  HEALTH = 9; 
	final private int MAX_HEALTH = 10; 
	final private int DAMAGE = 1; 
	final private int HEAL = 5; 
	 
	@Test
	/*
	 * test the correct creation of a basicLife instantiation. 
	 */
		void createLifeTest() { 
		BasicLife life = new BasicLifeImpl(this.HEALTH, this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
		life = new BasicLifeImpl(this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
	}
	
	@Test
	/*
	 * test that the currentHealth is always <= maxHealth.
	 */
	void advancedCreateLifeTest() { 
		BasicLife life = new BasicLifeImpl(this.MAX_HEALTH + 1, this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
	}
	
	@Test
	/*
	 * test the proper operation of the method takeDamage.
	 */
		void takeDamageTest() {
		BasicLife life = new BasicLifeImpl(this.HEALTH, this.MAX_HEALTH);
		life.takeDamage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.HEALTH-this.DAMAGE);
		life.takeDamage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.getCurrentHealth() == 0);
	}

	@Test
	/*
	 * test the proper operation of the method heal.
	 */
	void healTest() {
		BasicLife life = new BasicLifeImpl(1, this.MAX_HEALTH);
		life.heal(HEAL);
		assertTrue(life.getCurrentHealth() == (this.HEAL + 1));
		life.heal(this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH); 
	}

}
