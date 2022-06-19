package model.game_object;

import model.weapon.Weapon;

/**
 * 
 * Declare the method for the game object that can hold a weapon. 
 */
public interface WeaponizedObject extends GameObject{

  /**
   * @return the weapon that the entity is holding.
   */
  Weapon getWeapon();
}
