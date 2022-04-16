package logics.weapon;

import logics.strategy.Strategy;

/**
 * 
 * Interface that declares methods for the weapon factory.
 *
 */
public interface WeaponFactory {

	/**
	 * @param damage is the damage that the weapon can inflict
	 * @param shootingStrategy is the shooting strategy of the weapon
	 * @return a weapon
	 */
	public Weapon createWeapon(int damage, Strategy shootingStrategy);

}
