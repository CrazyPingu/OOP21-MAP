package logics.weapon.shootingStrategy;

import java.util.List;

import utilis.Pair;

/**
 * 
 * Interface that declares methods for the shooting strategy of each weapon.
 *
 */
public interface ShootingStrategy {

	/**
	 * @return a List<Pair<>> that rappresent the cells where the weapon can shoot.
	 */
	public List<Pair<Integer, Integer>> apply();

}
