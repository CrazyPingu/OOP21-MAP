package logics.game_object.entity.enemy;

import logics.game_object.entity.SimpleEntity;
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
	public SimpleEntity createZombieStick(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using an axe as a weapon.
	 */
	public SimpleEntity createZombieAxe(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using a dagger as a weapon.
	 */
	public SimpleEntity createZombieDagger(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using a tube as a weapon.
	 */
	public SimpleEntity createZombieTube(Pair<Integer, Integer> pos);
	
	/**
	 * @return a new enemy using a gun as a weapon.
	 */
	public SimpleEntity createZombieGun(Pair<Integer, Integer> pos);


}
