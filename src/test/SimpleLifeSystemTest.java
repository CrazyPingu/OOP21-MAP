package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.life_system.impl.SimpleLifeSystem;

/**
 * 
 * Test a simple life system
 */
class SimpleLifeSystemTest {
  private static final int HEALTH = 9;
  private static final int DAMAGE = 1;

  /**
   * Test the correct creation of a SimpleLifeSystem instantiation.
   */
  @Test
  void createLifeTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    assertEquals(life.getCurrentHealth(), HEALTH);
  }

  /*
   * Test the proper operation of the method damage.
   */
  @Test
  void damageTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    life.damage(-DAMAGE); // test that damage don't work with negative value
    assertEquals(life.getCurrentHealth(), HEALTH);
    life.damage(DAMAGE);
    assertEquals(life.getCurrentHealth(), HEALTH - DAMAGE);
    life.damage(DAMAGE);
    assertEquals(life.getCurrentHealth(), HEALTH - (2 * DAMAGE));
  }

  /*
   * Test that the health value does not go below zero
   */
  @Test
  void healthNotBelowZeroTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertEquals(life.getCurrentHealth(), 0);
  }

  /*
   * Test the correct working of the isDead method
   */
  @Test
  void isDeadTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    assertFalse(life.isDead());
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.isDead());

  }
}
