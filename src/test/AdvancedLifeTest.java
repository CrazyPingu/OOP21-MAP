package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logics.life.AdvancedLife;
import logics.life.AdvancedLifeImpl;
import logics.life.BasicLife;
import logics.life.BasicLifeImpl;

public class AdvancedLifeTest {

	final private int HEALTH = 5;
	final private int MAX_HEALTH = 10;
	final private int MAX_HEALTH_LIMIT = 15;
	final private int DAMAGE = 3;
	final private int HEAL = 5;
	final private int EXTEND_HEALTH = 3; 

	@Test
	void createAdvancedLifeTest() {
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		assertTrue(life.getCurrentHealth() == this.HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
		assertTrue(life.getMaxHealthLimit() == this.MAX_HEALTH_LIMIT);
	}

	@Test
	void takeDamageTest() {
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.takeDamage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.HEALTH - this.DAMAGE);
		life.takeDamage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.getCurrentHealth() == 0);
	}

	@Test
	void healTest() {
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.heal(HEAL);
		assertTrue(life.getCurrentHealth() == this.HEALTH + this.HEAL);
		life.heal(this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH);
	}
	
	@Test
	void increaseMaxHealthTest() { 
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.upgradeMaxHealth(this.EXTEND_HEALTH + life.getMaxHealth());
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH + this.EXTEND_HEALTH);
		life.upgradeMaxHealth(life.getMaxHealthLimit()+1);
		assertTrue(life.getMaxHealth() == life.getMaxHealthLimit());
	}
	
	@Test 
	void decreseMaxHealthTest() { 
		AdvancedLife life = new AdvancedLifeImpl(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		life.upgradeMaxHealth(0);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
		life.upgradeMaxHealth(this.MAX_HEALTH-1);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH-1);
	}
}
