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
	public void move(SimpleEnemy enemy) {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	public void attack(SimpleEnemy enemy, Player player) {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isPlayerInAttackArea(SimpleEnemy enemy, Player player, Pair<Integer,Integer> roomSize) {
		List<Pair<Integer,Integer>> attackableArea = enemy.getWeapon().getAttackArea(enemy.getPos(), roomSize);
		return (attackableArea.contains(player.getPos()));
	}
	
}
