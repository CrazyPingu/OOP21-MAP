package logics.game_object;

import logics.strategy.weapon.Weapon;

/**
 * 
 * Declare the method for the game object that can hold a weapon
 *
 */
public interface WeaponizedObject {

  /**
   * @return the weapon that the entity is holding.
   */
  Weapon getWeapon();
}
