package logics.weapon;

import logics.strategy.Strategy;

/**
 * 
 * Create the weapon designed by the passed value implementing the weapon
 * interface.
 *
 */
public class WeaponImpl implements Weapon {
	private int damage;
	private String name;
	private Strategy shootingStrategy;

	/**
	 * @param damage is the damage that the weapon can inflict
	 * @param shootingStrategy is the area within the weapon can reach
	 */
	public WeaponImpl(int damage, String name, Strategy shootingStrategy) {
		this.damage = damage;
		this.name = name;
		this.shootingStrategy = shootingStrategy;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * {@inheritDoc}
	 */
	public Strategy getShootingStrategy() {
		return shootingStrategy;
	}

}
