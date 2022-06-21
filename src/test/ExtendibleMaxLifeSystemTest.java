package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.life_system.impl.ExtendibleMaxLifeSystem;

/**
 * 
 * Test the extendible max life system
 */
class ExtendibleMaxLifeSystemTest {
  private static final int HEALTH = 9;
  private static final int MAX_HEALTH = 10;
  private static final int MAX_HEALTH_EXTENSION = 15;
  private static final int DAMAGE = 1;
  private static final int HEAL = 5;

  /**
   * Test the creation of the life system
   */
  @Test
  void createLifeTest() {
    ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    assertEquals(life.getCurrentHealth(), HEALTH);
    assertEquals(life.getMaxHealth(), MAX_HEALTH);

    /*
     * test than the LifeSystem can't be created with a starting life value greater
     * tha maxHealth value
     */
    life = new ExtendibleMaxLifeSystem(MAX_HEALTH + 1, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    assertEquals(life.getMaxHealth(), MAX_HEALTH);

    /*
     * test than the LifeSystem can't be created with a maximum Health value greater
     * tha maxHealthExtension value
     */
    life = new ExtendibleMaxLifeSystem(MAX_HEALTH, MAX_HEALTH_EXTENSION + 1, MAX_HEALTH_EXTENSION);
    assertEquals(life.getMaxHealthReachable(), MAX_HEALTH_EXTENSION);

  }

  /**
   * Test the proper operation of the method damage.
   */
  @Test
  void damageTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    life.damage(DAMAGE);
    assertEquals(life.getCurrentHealth(), HEALTH - DAMAGE);
    life.damage(DAMAGE);
    assertEquals(life.getCurrentHealth(), HEALTH - (2 * DAMAGE));
  }

  /**
   * Test that the health value does not go below zero
   */
  @Test
  void healthNotBelowZeroTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertEquals(life.getCurrentHealth(), 0);
  }

  /**
   * Test the correct working of the isDead method
   */
  @Test
  void isDeadTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    assertFalse(life.isDead());
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.isDead());
  }

  /**
   * Test the correct working of the heal method
   */
  @Test
  void healTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(MAX_HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    // test that heal don't work with negative value
    life.heal(-HEAL);
    assertEquals(life.getCurrentHealth(), MAX_HEALTH);
    life.damage(MAX_HEALTH - (HEAL - 1));
    life.heal(HEAL);
    assertEquals(life.getCurrentHealth(), MAX_HEALTH - 1);
    life.heal(MAX_HEALTH);
    assertEquals(life.getCurrentHealth(), MAX_HEALTH);
  }

  /**
   * Test the correct working of the heal method
   */
  @Test
  void increaseMaxHealthTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);

    life.setMaxHealth(MAX_HEALTH + 1);
    assertEquals(life.getMaxHealth(), MAX_HEALTH + 1);

    life.setMaxHealth(MAX_HEALTH + 2);
    assertEquals(life.getMaxHealth(), MAX_HEALTH + 2);

    life.setMaxHealth(MAX_HEALTH - 5);
    assertEquals(life.getMaxHealth(), MAX_HEALTH - 5);

    life.setMaxHealth(MAX_HEALTH_EXTENSION + 1);
    assertEquals(life.getMaxHealth(), MAX_HEALTH_EXTENSION);

    final int currentMaxHealth = life.getMaxHealth();
    life.setMaxHealth(0);
    assertEquals(life.getMaxHealth(), currentMaxHealth);

  }

}
