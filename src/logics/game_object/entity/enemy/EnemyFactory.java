package logics.game_object.entity.enemy;

import logics.game_object.entity.SimpleEnemy;
import utilis.Pair;

/**
 * 
 * Interface that declares methods for the enemy factory.
 *
 */
public interface EnemyFactory {

	/**
	 * @return a new enemy using a stick as a weapon.
	 */
	public SimpleEnemy createZombieStick(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using an axe as a weapon.
	 */
	public SimpleEnemy createZombieAxe(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using a dagger as a weapon.
	 */
	public SimpleEnemy createZombieDagger(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using a tube as a weapon.
	 */
	public SimpleEnemy createZombieTube(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using a gun as a weapon.
	 */
	public SimpleEnemy createZombieGun(Pair<Integer, Integer> pos);


}
