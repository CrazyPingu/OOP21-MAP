package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.awt.Image;
import org.junit.jupiter.api.Test;
import model.game_object.entity.Player;
import model.life_system.impl.ExtendibleMaxLifeSystem;
import model.movement.MovementFactory;
import model.movement.MovementFactoryImpl;
import model.weapon.WeaponFactory;
import model.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;

/**
 * 
 * Test the player class
 */
class PlayerTest {
  private static final int HEALTH = 9;
  private static final int MAX_HEALTH = 15;
  private static final int MAX_HEALTH_LIMIT = 20;
  private static final int HEAL = 5;
  private static final int DAMAGE = 2;
  private static final String NAME = "PLAYER";
  private static final Image TEXTURE = EntityTexture.PLAYER;
  private static final Pair<Integer, Integer> START_POS = new Pair<>(1, 1);

  private MovementFactory movementFactory = new MovementFactoryImpl();
  private WeaponFactory weaponFactory = new WeaponFactoryImpl();
  private ExtendibleMaxLifeSystem life;
  private Player player;

  /**
   * Test the correct creation of a Player instantiation.
   */
  @Test
  void simplePlayerCreationTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(life, START_POS, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE, DAMAGE);
    assertEquals(this.player.getHealth(), HEALTH);
    assertEquals(this.player.getMaxHealth(), MAX_HEALTH);
    assertEquals(this.player.getPos(), START_POS);
    assertEquals(NAME, this.player.getName());
    assertFalse(this.player.isDead());

    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);
    assertEquals(this.player.getHealth(), HEALTH);
    assertEquals(this.player.getMaxHealth(), MAX_HEALTH);
    assertEquals(this.player.getPos(), new Pair<Integer, Integer>(0, 0));
    assertEquals(NAME, this.player.getName());
    assertFalse(this.player.isDead());
  }

  /**
   * Test the proper operation of the method damage.
   */
  @Test
  void damageEntityTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);
    this.player.damage(DAMAGE);
    assertEquals(this.player.getHealth(), HEALTH - DAMAGE);
  }

  /**
   * Test that the health value does not go below zero
   */
  @Test
  void healthNotBelowZeroTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);
    this.player.damage(this.player.getHealth() + DAMAGE);
    assertEquals(this.player.getHealth(), 0);
  }

  /**
   * Test the correct functioning of the isDead method
   */
  @Test
  void isDeadTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);
    this.player.damage(this.player.getHealth() + DAMAGE);
    assertTrue(this.player.isDead());
  }

  /**
   * Test the heal method
   */
  @Test
  void healTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);

    // test the correct funcioning of the method heal
    this.player.heal(HEAL);
    assertEquals(this.player.getHealth(), HEALTH + HEAL);

    // test than health can reach the max health value
    this.player.heal(MAX_HEALTH);
    assertEquals(this.player.getHealth(), MAX_HEALTH);

    // test the health value can't be increase into a value greater than max health
    this.player.heal(MAX_HEALTH + 1);
    assertEquals(this.player.getHealth(), MAX_HEALTH);
  }

  /**
   * Test that the heal method do nothing after the player is dead
   */
  @Test
  void healAfterDeath() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);

    // the player die
    this.player.damage(this.player.getHealth());
    assertTrue(this.player.isDead());
    assertEquals(this.player.getHealth(), 0);

    // try to heal the player
    this.player.heal(HEAL);
    assertTrue(this.player.isDead());
    assertEquals(this.player.getHealth(), 0);
  }

  /**
   * test the max health stay in the correct range specified in the constructor
   */
  @Test
  void maxHealthInRange() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);
    // test the functioning of the method setMaxHealth
    this.player.setMaxHealth(MAX_HEALTH_LIMIT - 3);
    assertEquals(this.player.getMaxHealth(), MAX_HEALTH_LIMIT - 3);
    this.player.setMaxHealth(MAX_HEALTH_LIMIT);
    assertEquals(this.player.getMaxHealth(), MAX_HEALTH_LIMIT);

    // test the max health value can't be set greater than the limit
    this.player.setMaxHealth(MAX_HEALTH_LIMIT + 5);
    assertEquals(this.player.getMaxHealth(), MAX_HEALTH_LIMIT);
  }

  @Test
  /**
   * Test toString result
   */
  void playerPrintTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.createStepMovement(), NAME,
        TEXTURE);

    System.out.println(this.player.toString());
  }
}
