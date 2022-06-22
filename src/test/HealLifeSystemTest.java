package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.life_system.impl.HealLifeSystem;

/**
 * 
 * Test the heal life system
 */
class HealLifeSystemTest {
  private static final int HEALTH = 9;
  private static final int MAX_HEALTH = 10;
  private static final int DAMAGE = 1;
  private static final int HEAL = 5;

  /**
   * Test the creation of the life system
   */
  @Test
  void createLifeTest() {
    HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
    assertEquals(life.getCurrentHealth(), HEALTH);
    assertEquals(life.getMaxHealth(), MAX_HEALTH);

    // test than the LifeSystem can't be created with a starting life value greater
    // tha maxHealth value
    life = new HealLifeSystem(MAX_HEALTH + 1, MAX_HEALTH);
    assertEquals(life.getMaxHealth(), MAX_HEALTH);

  }

  /**
   * Test the proper operation of the method damage.
   */
  @Test
  void damageTest() {
    final HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
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
    final HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertEquals(life.getCurrentHealth(), 0);
  }

  /**
   * Test the correct working of the isDead method
   */
  @Test
  void isDeadTest() {
    final HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
    assertFalse(life.isDead());
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.isDead());
  }

  /**
   * Test the correct working of the heal method
   */
  @Test
  void healTest() {
    final HealLifeSystem life = new HealLifeSystem(MAX_HEALTH, MAX_HEALTH);
    life.heal(-HEAL); // test that heal don't work with negative value
    assertEquals(life.getCurrentHealth(), MAX_HEALTH);
    life.damage(MAX_HEALTH - (HEAL - 1));
    life.heal(HEAL);
    assertEquals(life.getCurrentHealth(), MAX_HEALTH - 1);
    life.heal(MAX_HEALTH);
    assertEquals(life.getCurrentHealth(), MAX_HEALTH);
  }
}
