package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import logics.life.HealLifeSystem;

public class HealLifeSystemTest {
  private static final int HEALTH = 9;
  private static final int MAX_HEALTH = 10;
  private static final int DAMAGE = 1;
  private static final int HEAL = 5;

  @Test
  /*
   * test the correct creation of a HealLifeSystem instantiation.
   */
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  public void createLifeTest() {
    HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
    assertTrue(life.getCurrentHealth() == HEALTH);
    assertTrue(life.getMaxHealth() == MAX_HEALTH);

    // test than the LifeSystem can't be created with a starting life value greater
    // tha maxHealth value
    life = new HealLifeSystem(MAX_HEALTH + 1, MAX_HEALTH);
    assertTrue(life.getMaxHealth() == MAX_HEALTH);

  }

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the proper operation of the method damage.
   */
  public void damageTest() {
    final HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
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
  public void healthNotBelowZeroTest() {
    final HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.getCurrentHealth() == 0);
  }

  @Test
  /*
   * test the correct working of the isDead method
   */
  public void isDeadTest() {
    final HealLifeSystem life = new HealLifeSystem(HEALTH, MAX_HEALTH);
    assertFalse(life.isDead());
    life.damage(life.getCurrentHealth() + DAMAGE);
    assertTrue(life.isDead());
  }

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the correct working of the heal method
   */
  public void healTest() {
    final HealLifeSystem life = new HealLifeSystem(MAX_HEALTH, MAX_HEALTH);
    life.heal(-HEAL); // test that heal don't work with negative value
    assertTrue(life.getCurrentHealth() == MAX_HEALTH);
    life.damage(MAX_HEALTH - (HEAL - 1));
    life.heal(HEAL);
    assertTrue(life.getCurrentHealth() == MAX_HEALTH - 1);
    life.heal(MAX_HEALTH);
    assertTrue(life.getCurrentHealth() == MAX_HEALTH);
  }
}
