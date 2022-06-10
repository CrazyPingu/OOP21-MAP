package model.life_system;

/**
 * 
 * This class declare all the common method for a Life System that can use a
 * method to heal and can upgrade the maximum health value
 *
 */
public interface ExtendibleMaxHealthSystem extends HealSystem {

  /**
   * 
   * @param lifeExtension represent the new maximum amount of health the system
   *                      can reach. It has to be greater than zero and less than
   *                      maxHealthExtension value. If the passed value is greater
   *                      than maxHealthExtension is automatically reduced to
   *                      maxHealthExtension value. If is equal or less than 0 do
   *                      nothing.
   */
  void setMaxHealth(int lifeExtension);

  /**
   * 
   * @return the current maximum amounth of health the sistem can reach using the
   *         heal method
   */
  int getMaxHealthReachable();

}
