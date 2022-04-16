package logics.weapon;

import logics.strategy.Strategy;

/**
 * 
 * Interface that declares methods for the weapon.
 * Represent the "Context" of Factory interface.
 *
 */
public interface Weapon {

	/**
	 * @return the damage of the weapon.
	 */
	public int getDamage();

	/**
	 * @return the shooting strategy applied.
	 */
	public Strategy getShootingStrategy();
}
