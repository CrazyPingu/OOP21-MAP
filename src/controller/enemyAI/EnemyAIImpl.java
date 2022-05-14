package controller.enemyAI;

import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;

/**
 * 
 * Implementation of enemies behaviors.
 *
 */
public class EnemyAIImpl implements EnemyAI {

	/**
	 * {@inheritDoc}
	 */
	public void move(SimpleEnemy enemy, Player player, Pair<Integer,Integer> roomSize) {
		List<Pair<Integer,Integer>> enemyReachableArea = enemy.getMovementSystem().reachableCells(enemy.getPos(), roomSize);
		
		//cella della reachable area + vicina al player
	}

	/**
	 * {@inheritDoc}
	 */
	public void attack(SimpleEnemy enemy, Player player) {
		player.damage(enemy.getWeapon().getDamage());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isPlayerInAttackArea(SimpleEnemy enemy, Player player, Pair<Integer,Integer> roomSize) {
		List<Pair<Integer,Integer>> attackableArea = enemy.getWeapon().getAttackArea(enemy.getPos(), roomSize);
		return (attackableArea.contains(player.getPos()));
	}
	
}
