package logics.entity;

/**
 * 
 * Interface that declares methods for the enemy factory.
 *
 */
public interface EnemyFactory {

	/**
	 * @return a new enemy.
	 */
	public Entity createEnemy();
}
