package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Image;
import org.junit.jupiter.api.Test;
import logics.game_object.entity.SimpleEnemy;
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

	/*
	 * TODO delete the null field texture is null because when the text was made it
	 * was not imported the image yet.
	 * 
	 */
	final private Image texture = null;
	final private Pair<Integer, Integer> START_POS = new Pair<Integer, Integer>(1, 1);

	private MovementFactory movementFactory = new MovementFactoryImpl();
	private WeaponFactory weaponFactory = new WeaponFactoryImpl();
	private LifeSystem life;
	private SimpleEnemy entity;

	@Test
	/*
	 * test the correct creation of a SimpleLifeSystem instantiation.
	 */
	public void SimpleEntityCreationTest() {
		this.life = new SimpleLifeSystem(HEALTH);
		this.entity = new SimpleEnemy(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		assertTrue(this.entity.getHealth() == this.HEALTH);
		assertTrue(this.entity.getPos().equals(this.START_POS));
		assertTrue(this.entity.getName().equals(NAME));
		assertFalse(this.entity.isDead());
	}

	@Test
	/*
	 * test the proper operation of the method damage.
	 */
	public void damageEntityTest() {
		this.life = new SimpleLifeSystem(HEALTH);
		this.entity = new SimpleEnemy(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		this.entity.damage(this.DAMAGE);
		assertTrue(this.entity.getHealth() == this.HEALTH - this.DAMAGE);
	}

	@Test
	/*
	 * test that the health value does not go below zero
	 */
	public void healthNotBelowZeroTest() {
		this.life = new SimpleLifeSystem(HEALTH);
		this.entity = new SimpleEnemy(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		this.entity.damage(this.entity.getHealth() + this.DAMAGE);
		assertTrue(this.entity.getHealth() == 0);
	}

	@Test
	/*
	 * test the correct working of the isDead method
	 */
	public void isDeadTest() {
		this.life = new SimpleLifeSystem(HEALTH);
		this.entity = new SimpleEnemy(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		this.entity.damage(this.entity.getHealth() + this.DAMAGE);
		assertTrue(this.entity.isDead());
	}
}
