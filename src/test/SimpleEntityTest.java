package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logics.game_object.entity.SimpleEntity;
import logics.life.LifeSystem;
import logics.life.SimpleLifeSystem;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactory;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilis.Pair;

public class SimpleEntityTest {
	final private int HEALTH = 9;
	final private int DAMAGE = 1;
	final private String NAME = "name";
	final private String PATH = "texturePath";
	final private Pair<Integer, Integer> START_POS = new Pair<Integer, Integer>(1, 1);

	private MovementFactory movementFactory = new MovementFactoryImpl();
	private WeaponFactory weaponFactory = new WeaponFactoryImpl();
	private LifeSystem life;
	private SimpleEntity entity;

	@Test
	/*
	 * test the correct creation of a SimpleLifeSystem instantiation.
	 */
	public void SimpleEntityCreationTest() {
		this.life = new SimpleLifeSystem(HEALTH);
		this.entity = new SimpleEntity(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.PATH);
		assertTrue(this.entity.getHealth() == this.HEALTH);
		assertTrue(this.entity.getPos().equals(this.START_POS));
		assertTrue(this.entity.getName().equals(NAME));
		assertTrue(this.entity.getImagePath().equals(PATH));
		assertFalse(this.entity.isDead()); 
	}

	@Test
	/*
	 * test the proper operation of the method damage.
	 */
	public void damageEntityTest() {
		this.life = new SimpleLifeSystem(HEALTH);
		this.entity = new SimpleEntity(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.PATH);
		this.entity.damage(this.DAMAGE);
		assertTrue(this.entity.getHealth() == this.HEALTH - this.DAMAGE);
	}

	@Test
	/*
	 * test that the health value does not go below zero
	 */
	public void healthNotBelowZeroTest() {

	}

	@Test
	/*
	 * test the correct working of the isDead method
	 */
	public void isDeadTest() {

	}
}
