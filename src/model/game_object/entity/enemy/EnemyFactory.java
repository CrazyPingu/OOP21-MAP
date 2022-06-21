package model.game_object.entity.enemy;

import model.game_object.entity.SimpleEnemy;
import utilities.Pair;

/**
 * 
 * Interface that declares methods for the enemy factory.
 *
 */
public interface EnemyFactory {

  /**
   * Different types of health values.
   */
  enum Health {
    LOW_HEALTH(5), MID_HEALTH(7), HIGH_HEALTH(10);

    private final int health;

    /**
     * 
     * @param health the health of the enum
     */
    Health(final int health) {
      this.health = health;
    }

    /**
     * 
     * @return the relative health of the enum
     */
    public int getHealth() {
      return this.health;
    }

  }

  /**
   * Different enemies' names.
   */
  enum Name {
    STICK("zombie stick"), AXE("zombie axe"), DAGGER("zombie dagger"), TUBE("zombie tube"), GUN("zombie gun");

    private String name;

    /**
     * 
     * @param name the name that correspond to the weapon
     */
    Name(final String name) {
      this.name = name;
    }

    /**
     * 
     * @return the name of the weapon
     */
    public String getName() {
      return this.name;
    }
  }

  /**
   * 
   * @param pos the position to spawn the enemy
   * @return a new enemy using a stick as a weapon.
   */
  SimpleEnemy createZombieStick(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos the position to spawn the enemy
   * @return a new enemy using an axe as a weapon.
   */
  SimpleEnemy createZombieAxe(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos the position to spawn the enemy
   * @return a new enemy using a dagger as a weapon.
   */
  SimpleEnemy createZombieDagger(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos the position to spawn the enemy
   * @return a new enemy using a tube as a weapon.
   */
  SimpleEnemy createZombieTube(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos the position to spawn the enemy
   * @return a new enemy using a gun as a weapon.
   */
  SimpleEnemy createZombieGun(Pair<Integer, Integer> pos);

}
