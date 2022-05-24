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
import utilities.Pair;
import utilities.texture.EntityTexture;

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

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the correct creation of a Player instantiation.
   */
  void simplePlayerCreationTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(life, START_POS, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE, DAMAGE);
    assertTrue(this.player.getHealth() == HEALTH);
    assertTrue(this.player.getMaxHealth() == MAX_HEALTH);
    assertTrue(this.player.getPos().equals(START_POS));
    assertTrue(NAME.equals(this.player.getName()));
    assertFalse(this.player.isDead());

    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);
    assertTrue(this.player.getHealth() == HEALTH);
    assertTrue(this.player.getMaxHealth() == MAX_HEALTH);
    assertTrue(this.player.getPos().equals(new Pair<Integer, Integer>(0, 0)));
    assertTrue(NAME.equals(this.player.getName()));
    assertFalse(this.player.isDead());
  }

  @Test
  /*
   * test the proper operation of the method damage.
   */
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  void damageEntityTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);
    this.player.damage(DAMAGE);
    assertTrue(this.player.getHealth() == HEALTH - DAMAGE);
  }

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test that the health value does not go below zero
   */
  void healthNotBelowZeroTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);
    this.player.damage(this.player.getHealth() + DAMAGE);
    assertTrue(this.player.getHealth() == 0);
  }

  @Test
  /*
   * test the correct functioning of the isDead method
   */
  void isDeadTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);
    this.player.damage(this.player.getHealth() + DAMAGE);
    assertTrue(this.player.isDead());
  }

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the heal method
   */
  void healTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);

    // test the correct funcioning of the method heal
    this.player.heal(HEAL);
    assertTrue(this.player.getHealth() == HEALTH + HEAL);

    // test than health can reach the max health value
    this.player.heal(MAX_HEALTH);
    assertTrue(this.player.getHealth() == MAX_HEALTH);

    // test the health value can't be increase into a value greater than max health
    this.player.heal(MAX_HEALTH + 1);
    assertTrue(this.player.getHealth() == MAX_HEALTH);
  }

  @Test
  /*
   * test that the heal method do nothing after the player is dead
   */
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  void healAfterDeath() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);

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
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the max health stay in the correct range specified in the constructor
   */
  void maxHealthInRange() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);
    // test the functioning of the method setMaxHealth
    this.player.setMaxHealth(MAX_HEALTH_LIMIT - 3);
    assertTrue(this.player.getMaxHealth() == MAX_HEALTH_LIMIT - 3);
    this.player.setMaxHealth(MAX_HEALTH_LIMIT);
    assertTrue(this.player.getMaxHealth() == MAX_HEALTH_LIMIT);

    // test the max health value can't be set greater than the limit
    this.player.setMaxHealth(MAX_HEALTH_LIMIT + 5);
    assertTrue(this.player.getMaxHealth() == MAX_HEALTH_LIMIT);
  }

  @Test
  /*
   * test toString result
   */
  void playerPrintTest() {
    this.life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_LIMIT);
    this.player = new Player(this.life, this.weaponFactory.createAxe(), this.movementFactory.stepMovement(), NAME,
        TEXTURE);

    System.out.println(this.player.toString());
  }
}
