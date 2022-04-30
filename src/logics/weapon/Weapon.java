package logics.weapon;

import java.util.List;

import utilis.Pair;

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
	 * @return the name of the weapon.
	 */
	public String getName();
	/**
	 * @return list of available cells to attack based on shooting strategy applied.
	 */
	public List<Pair<Integer, Integer>> getAttackArea(Pair<Integer, Integer> pos, Pair<Integer, Integer> size);
}
