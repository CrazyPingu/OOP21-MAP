package logics.game_object;

import logics.strategy.weapon.Weapon;

/**
 * 
 * Declare the method for the game_object that can hold a weapon
 *
 */
public interface WeponizedObject {

	/**
	 * @return the weapon that the entity is holding.
	 */
	public Weapon getWeapon();
}
