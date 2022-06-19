package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import model.life_system.impl.ExtendibleMaxLifeSystem;

class ExtendibleMaxLifeSystemTest {
  private static final int HEALTH = 9;
  private static final int MAX_HEALTH = 10;
  private static final int MAX_HEALTH_EXTENSION = 15;
  private static final int DAMAGE = 1;
  private static final int HEAL = 5;

  @Test

  void createLifeTest() {
    ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    assertTrue(life.getCurrentHealth() == HEALTH);
    assertTrue(life.getMaxHealth() == MAX_HEALTH);

    /*
     * test than the LifeSystem can't be created with a starting life value greater
     * tha maxHealth value
     */
    life = new ExtendibleMaxLifeSystem(MAX_HEALTH + 1, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    assertTrue(life.getMaxHealth() == MAX_HEALTH);

    /*
     * test than the LifeSystem can't be created with a maximum Health value greater
     * tha maxHealthExtension value
     */
    life = new ExtendibleMaxLifeSystem(MAX_HEALTH, MAX_HEALTH_EXTENSION + 1, MAX_HEALTH_EXTENSION);
    assertTrue(life.getMaxHealthReachable() == MAX_HEALTH_EXTENSION);

  }

  @Test
  /*
   * test the proper operation of the method damage.
   */
  void damageTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    life.damage(DAMAGE);
    assertTrue(life.getCurrentHealth() == HEALTH - DAMAGE);
    life.damage(DAMAGE);
    assertTrue(life.getCurrentHealth() == HEALTH - (2 * DAMAGE));
  }

  @Test
  /*
   * test that the health value does not go below zero
   */
  void healthNotBelowZeroTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.getCurrentHealth() == 0);
  }

  @Test
  /*
   * test the correct working of the isDead method
   */
  void isDeadTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    assertFalse(life.isDead());
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.isDead());
  }

  @Test
  /*
   * test the correct working of the heal method
   */
  void healTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(MAX_HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);
    // test that heal don't work with negative value
    life.heal(-HEAL);
    assertTrue(life.getCurrentHealth() == MAX_HEALTH);
    life.damage(MAX_HEALTH - (HEAL - 1));
    life.heal(HEAL);
    assertTrue(life.getCurrentHealth() == MAX_HEALTH - 1);
    life.heal(MAX_HEALTH);
    assertTrue(life.getCurrentHealth() == MAX_HEALTH);
  }

  @Test
  /*
   * test the correct working of the heal method
   */
   void increaseMaxHealthTest() {
    final ExtendibleMaxLifeSystem life = new ExtendibleMaxLifeSystem(HEALTH, MAX_HEALTH, MAX_HEALTH_EXTENSION);

    life.setMaxHealth(MAX_HEALTH + 1);
    assertTrue(life.getMaxHealth() == MAX_HEALTH + 1);

    life.setMaxHealth(MAX_HEALTH + 2);
    assertTrue(life.getMaxHealth() == MAX_HEALTH + 2);

    life.setMaxHealth(MAX_HEALTH - 5);
    assertTrue(life.getMaxHealth() == MAX_HEALTH - 5);

    life.setMaxHealth(MAX_HEALTH_EXTENSION + 1);
    assertTrue(life.getMaxHealth() == MAX_HEALTH_EXTENSION);

    final int currentMaxHealth = life.getMaxHealth();
    life.setMaxHealth(0);
    assertTrue(life.getMaxHealth() == currentMaxHealth);

  }

}
