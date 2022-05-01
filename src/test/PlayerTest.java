package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Image;
import org.junit.jupiter.api.Test;

import logics.game_object.entity.Player;
import logics.life.ExtendibleMaxLifeSystem;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactory;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilis.Pair;

public class PlayerTest {
	final private int HEALTH = 9;
	final private int MAX_HEALTH = 15;
	final private int MAX_HEALTH_LIMIT = 20;
	final private int HEAL = 5;
	final private int DAMAGE = 2;
	final private String NAME = "PLAYER";

	/*
	 * TODO delete the null field texture is null because when the text was made it
	 * was not imported the image yet.
	 * 
	 */
	final private Image texture = null;
	final private Pair<Integer, Integer> START_POS = new Pair<Integer, Integer>(1, 1);

	private MovementFactory movementFactory = new MovementFactoryImpl();
	private WeaponFactory weaponFactory = new WeaponFactoryImpl();
	private ExtendibleMaxLifeSystem life;
	private Player player;

	@Test
	/*
	 * test the correct creation of a SimpleLifeSystem instantiation.
	 */
	public void SimpleEntityCreationTest() {
		this.life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		this.player = new Player(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		assertTrue(this.player.getHealth() == this.HEALTH);
		assertTrue(this.player.getMaxHealth() == this.MAX_HEALTH);
		assertTrue(this.player.getPos().equals(this.START_POS));
		assertTrue(this.player.getName().equals(NAME));
		assertFalse(this.player.isDead());
	}

	@Test
	/*
	 * test the proper operation of the method damage.
	 */
	public void damageEntityTest() {
		this.life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		this.player = new Player(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		this.player.damage(this.DAMAGE);
		assertTrue(this.player.getHealth() == this.HEALTH - this.DAMAGE);
	}

	@Test
	/*
	 * test that the health value does not go below zero
	 */
	public void healthNotBelowZeroTest() {
		this.life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		this.player = new Player(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		this.player.damage(this.player.getHealth() + this.DAMAGE);
		assertTrue(this.player.getHealth() == 0);
	}

	@Test
	/*
	 * test the correct functioning of the isDead method
	 */
	public void isDeadTest() {
		this.life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		this.player = new Player(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		this.player.damage(this.player.getHealth() + this.DAMAGE);
		assertTrue(this.player.isDead());
	}

	@Test
	/*
	 * test the heal method
	 */
	public void healTest() {
		this.life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		this.player = new Player(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);

		// test the correct funcioning of the method heal
		this.player.heal(HEAL);
		assertTrue(this.player.getHealth() == this.HEALTH + this.HEAL);

		// test than health can reach the max health value
		this.player.heal(MAX_HEALTH);
		assertTrue(this.player.getHealth() == this.MAX_HEALTH);

		// test the health value can't be increase into a value greater than max health
		this.player.heal(MAX_HEALTH + 1);
		assertTrue(this.player.getHealth() == this.MAX_HEALTH);
	}

	@Test
	/*
	 * test that the heal method do nothing after the player is dead
	 */
	public void healAfterDeath() {
		this.life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		this.player = new Player(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);

		// the player die
		this.player.damage(this.player.getHealth());
		assertTrue(this.player.isDead());
		assertTrue(this.player.getHealth() == 0);

		// try to heal the player
		this.player.heal(HEAL);
		assertTrue(this.player.isDead());
		assertTrue(this.player.getHealth() == 0);
	}

	@Test
	/*
	 * test the max health stay in the correct range specified in the constructor
	 */
	public void maxHealthInRange() {
		this.life = new ExtendibleMaxLifeSystem(this.HEALTH, this.MAX_HEALTH, this.MAX_HEALTH_LIMIT);
		this.player = new Player(this.life, this.START_POS, this.weaponFactory.createAxe(),
				this.movementFactory.stepMovement(), this.NAME, this.texture);
		// test the functioning of the method setMaxHealth
		this.player.setMaxHealth(MAX_HEALTH_LIMIT - 3);
		assertTrue(this.player.getMaxHealth() == MAX_HEALTH_LIMIT - 3);
		this.player.setMaxHealth(MAX_HEALTH_LIMIT);
		assertTrue(this.player.getMaxHealth() == MAX_HEALTH_LIMIT);

		// test the max health value can't be set greater than the limit
		this.player.setMaxHealth(MAX_HEALTH_LIMIT + 5);
		assertTrue(this.player.getMaxHealth() == MAX_HEALTH_LIMIT);
	}

}
