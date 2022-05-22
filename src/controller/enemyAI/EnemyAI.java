package controller.enemyAI;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;

/**
 * 
 * Methods to define enemies behaviors during their turn.
 *
 */
public interface EnemyAI {

	/**
	 * enemy automated movement
	 * 
	 * @param enemy: enemy of which is needed to change position
	 * @return the new calculated position for the enemy
	 */
	Pair<Integer, Integer> move(SimpleEnemy enemy);

	/**
	 * checks if player is reachable by the enemy attack
	 * 
	 * @param enemy:    entity of which is needed to know the attackable area
	 * @param player:   entity to be found whether or not is in the attackable area
	 * @param roomSize: size of the current room
	 */
	boolean isPlayerInAttackArea(SimpleEnemy enemy, Player player, Pair<Integer, Integer> roomSize);

}
