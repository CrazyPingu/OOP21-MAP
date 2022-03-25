package logics.weapon;

import java.util.List;

import utilis.Pair;

/**
 * 
 * Interface that declares methods for the weapon.
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
	public List<Pair<Integer, Integer>> getShootingStrategy();
}
