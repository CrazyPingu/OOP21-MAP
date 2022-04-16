package logics.weapon;

import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;

/**
 * 
 * Create the weapon designed by the passed value implementing the weapon
 * interface.
 *
 */
public class WeaponImpl implements Weapon {
	private int damage;
	private Strategy shootingStrategy;

	/**
	 * @param damage           : the damage of the weapon.
	 * @param shootingStrategy : where the weapon can shoot.
	 */
	public WeaponImpl(int damage, Strategy shootingStrategy) {
		this.damage = damage;
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
	public List<Pair<Integer, Integer>> getShootingStrategy() {
		return shootingStrategy.execute();
	}
}
