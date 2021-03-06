package model.life_system;

/**
 * 
 * this interface declare the methods for a life system that can use a method to
 * heal.
 */
public interface HealSystem extends LifeSystem {

  /**
   * 
   * @param healValue represent the amount of life to increase. The helth value
   *                  can't be greater than max health. Don't work with negative
   *                  values
   */
  void heal(int healValue);

  /**
   * 
   * @return the maximum amount of health that can be reached
   */
  int getMaxHealth();
}
