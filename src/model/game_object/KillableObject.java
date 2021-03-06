package model.game_object;

/**
 * 
 * Declare the common method for the game_object that can take damage and die
 */
public interface KillableObject extends GameObject{
  /**
   * @param damageValue value that will be decreased from the entity's current
   *                    health.
   */
  void damage(int damageValue);

  /**
   * 
   * @return the current amounth of health
   */
  int getHealth();

  /**
   * 
   * @return the life state of the entity (True = DEAD, FALSE = IN LIFE)
   */
  Boolean isDead();
}
