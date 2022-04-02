package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logics.life.AdvancedLife;
import logics.life.AdvancedLifeImpl;

public class AdvancedLifeTest {

	final private int HEALTH = 5;
	final private int MAX_HEALTH = 10;
	final private int MAX_HEALTH_LIMIT = 15;
	final private int DAMAGE = 3;
	final private int HEAL = 5;
	final private int EXTEND_HEALTH = 3; 

	@Test
	/*
	 * test the correct creation of an AdvancedLife instantiation.  
	 */
	void createAdvancedLifeTest() {
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		assertTrue(life.getCurrentHealth() == this.HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
		assertTrue(life.getMaxHealthLimit() == this.MAX_HEALTH_LIMIT);
	}

	@Test
	/*
	 * test the proprer operation of the method takeDamage
	 */
	void takeDamageTest() {
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.takeDamage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.HEALTH - this.DAMAGE);
		life.takeDamage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.getCurrentHealth() == 0);
	}

	@Test 
	/*
	 * test the proper operation of the method heal. 
	 */
	void healTest() {
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.heal(HEAL);
		assertTrue(life.getCurrentHealth() == this.HEALTH + this.HEAL);
		life.heal(this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH);
	}
	
	@Test
	/*
	 * test the proper operation of increasing the maxHealth value
	 */
	void increaseMaxHealthTest() { 
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.upgradeMaxHealth(this.EXTEND_HEALTH + life.getMaxHealth());
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH + this.EXTEND_HEALTH);
		life.upgradeMaxHealth(this.MAX_HEALTH_LIMIT+1);
		assertTrue(life.getMaxHealth() == life.getMaxHealthLimit());
	}
	
	@Test
	/*
	 * test the proper operation of decresing the maxHealth value
	 */
	void decreseMaxHealthTest() { 
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.upgradeMaxHealth(0);
		assertFalse(life.getMaxHealth() == 0);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
		life.upgradeMaxHealth(this.MAX_HEALTH-1);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH-1);
	}
}
