package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Image;
import org.junit.jupiter.api.Test;
import logics.game_object.entity.SimpleEnemy;
import logics.life.LifeSystem;
import logics.life.SimpleLifeSystem;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactory;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;

public class SimpleEntityTest {
  private static final int HEALTH = 9;
  private static final int DAMAGE = 1;
  private static final String NAME = "name";
  private static final Image TEXTURE = EntityTexture.PLAYER;
  private static final Pair<Integer, Integer> START_POS = new Pair<>(1, 1);

  private MovementFactory movementFactory = new MovementFactoryImpl();
  private WeaponFactory weaponFactory = new WeaponFactoryImpl();
  private LifeSystem life;
  private SimpleEnemy entity;

  @Test
  /*
   * test the correct creation of a SimpleLifeSystem instantiation.
   */
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  public void simpleEntityCreationTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.stepMovement(), NAME, TEXTURE);
    assertTrue(this.entity.getHealth() == HEALTH);
    assertTrue(this.entity.getPos().equals(START_POS));
    assertTrue(NAME.equals(this.entity.getName()));
    assertFalse(this.entity.isDead());
  }

  @Test
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  /*
   * test the proper operation of the method damage.
   */
  public void damageEntityTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.stepMovement(), NAME, TEXTURE);
    this.entity.damage(DAMAGE);
    assertTrue(this.entity.getHealth() == HEALTH - DAMAGE);
  }

  @Test
  /*
   * test that the health value does not go below zero
   */
  @SuppressWarnings("PMD.SimplifiableTestAssertion")
  public void healthNotBelowZeroTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.stepMovement(), NAME, TEXTURE);
    this.entity.damage(this.entity.getHealth() + DAMAGE);
    assertTrue(this.entity.getHealth() == 0);
  }

  @Test
  /*
   * test the correct working of the isDead method
   */
  public void isDeadTest() {
    this.life = new SimpleLifeSystem(HEALTH);
    this.entity = new SimpleEnemy(this.life, START_POS, this.weaponFactory.createAxe(),
        this.movementFactory.stepMovement(), NAME, TEXTURE);
    this.entity.damage(this.entity.getHealth() + DAMAGE);
    assertTrue(this.entity.isDead());
  }
}
