package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logics.life.impl.SimpleLifeSystem;

class SimpleLifeSystemTest {
  private static final int HEALTH = 9;
  private static final int DAMAGE = 1;

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the correct creation of a SimpleLifeSystem instantiation.
   */
  void createLifeTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    assertTrue(life.getCurrentHealth() == HEALTH);
  }

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the proper operation of the method damage.
   */
  void damageTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    life.damage(-DAMAGE); // test that damage don't work with negative value
    assertTrue(life.getCurrentHealth() == HEALTH);
    life.damage(DAMAGE);
    assertTrue(life.getCurrentHealth() == HEALTH - DAMAGE);
    life.damage(DAMAGE);
    assertTrue(life.getCurrentHealth() == HEALTH - (2 * DAMAGE));
  }

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test that the health value does not go below zero
   */
  void healthNotBelowZeroTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.getCurrentHealth() == 0);
  }

  @Test
  /*
   * test the correct working of the isDead method
   */
  void isDeadTest() {
    final SimpleLifeSystem life = new SimpleLifeSystem(HEALTH);
    assertFalse(life.isDead());
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.isDead());

  }
}
