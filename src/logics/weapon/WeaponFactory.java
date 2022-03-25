package logics.weapon;

import logics.weapon.shootingStrategy.ShootingStrategy;

/**
 * 
 * Interface that declares methods for the weapon factory.
 *
 */
public interface WeaponFactory {

	/**
	 * @param damage           : the damage that the weapon can deal.
	 * @param shootingStrategy : the shooting strategy of the weapon.
	 * @return a weapon with those statistic.
	 */
	public Weapon createWeapon(int damage, ShootingStrategy shootingStrategy);

}
