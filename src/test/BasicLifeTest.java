package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logics.life.BasicLife;
import logics.life.BasicLifeImpl;

public class BasicLifeTest {
	
	final private int  HEALTH = 10; 
	final private int MAX_HEALTH = 10; 
	final private int DAMAGE = 1; 
	final private int HEAL = 5; 
	 
	@Test
		void createLifeTest() { 
		BasicLife life = new BasicLifeImpl(this.HEALTH, this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.HEALTH);
		assertTrue(life.getMaxHealth() == this.MAX_HEALTH);
	}
	
	@Test
		void takeDamageTest() {
		BasicLife life = new BasicLifeImpl(this.HEALTH, this.MAX_HEALTH);
		life.takeDamage(this.DAMAGE);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH-this.DAMAGE);
		life.takeDamage(life.getCurrentHealth() + this.DAMAGE);
		assertTrue(life.getCurrentHealth() == 0);
	}
	
	@Test
	void healTest() {
		BasicLife life = new BasicLifeImpl(1, this.MAX_HEALTH);
		life.heal(HEAL);
		System.out.println(life.getCurrentHealth());
		assertTrue(life.getCurrentHealth() == (this.HEAL + 1));
		
		life.heal(this.MAX_HEALTH);
		assertTrue(life.getCurrentHealth() == this.MAX_HEALTH); 
	}
	
	
	
}
