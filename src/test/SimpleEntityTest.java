package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.awt.Image;
import org.junit.jupiter.api.Test;
import model.game_object.entity.SimpleEnemy;
import model.life_system.LifeSystem;
import model.life_system.impl.SimpleLifeSystem;
import model.movement.MovementFactory;
import model.movement.MovementFactoryImpl;
import model.weapon.WeaponFactory;
import model.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;

class SimpleEntityTest {
  private static final int HEALTH = 9;
  private static final int DAMAGE = 1;
  private static final String NAME = "name";
  private static final Image TEXTURE = EntityTexture.PLAYER;
  private static final Pair<Integer, Integer> START_POS = new Pair<>(1, 1);

  private MovementFactory movementFactory = new MovementFactoryImpl();
  private WeaponFactory weaponFactory = new WeaponFactoryImpl();
  private LifeSystem life;
  private SimpleEnemy entity;

  /**
   * Test the correct creation of a SimpleLifeSystem instantiation.
   */
  @Test
  void simpleEntityCreationTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.createStepMovement(), NAME, TEXTURE);
    assertEquals(this.entity.getHealth(), HEALTH);
    assertEquals(this.entity.getPos(), START_POS);
    assertEquals(NAME, this.entity.getName());
    assertFalse(this.entity.isDead());
  }

  /**
   * Test the proper operation of the method damage.
   */
  @Test
  void damageEntityTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.createStepMovement(), NAME, TEXTURE);
    this.entity.damage(DAMAGE);
    assertEquals(this.entity.getHealth(), HEALTH - DAMAGE);
  }

  /**
   * Test that the health value does not go below zero
   */
  @Test
  void healthNotBelowZeroTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.createStepMovement(), NAME, TEXTURE);
    this.entity.damage(this.entity.getHealth() + DAMAGE);
    assertEquals(this.entity.getHealth(), 0);
  }

  /**
   * Test the correct working of the isDead method
   */
  @Test
  void isDeadTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.createStepMovement(), NAME, TEXTURE);
    this.entity.damage(this.entity.getHealth() + DAMAGE);
    assertTrue(this.entity.isDead());
  }
}
