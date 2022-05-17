package controller.enemyAI;

import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import view.game.TotalPanel;

/**
 * 
 * Implementation of enemies behaviors.
 *
 */
public class EnemyAIImpl implements EnemyAI {
	
	private TotalPanel totalPanel;
	private Player player;

	public EnemyAIImpl(TotalPanel totalPanel, Player player) {
		this.totalPanel = totalPanel;
		this.player = player;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void move(SimpleEnemy enemy) {
		final List<Pair<Integer, Integer>> enemyReachableArea = enemy.getMovementSystem().reachableCells(enemy.getPos(),
				this.totalPanel.getGameArea().getRoom().getSize());
		Pair<Integer, Integer> newEnemyPos = enemy.getPos();
		int minDistance = Integer.MAX_VALUE;
		int distance = -1;

		for (Pair<Integer, Integer> cell : enemyReachableArea) {
			distance = Math.abs(cell.getX() - this.player.getPos().getX()) + Math.abs(cell.getY() - this.player.getPos().getY());
			if (distance < minDistance) {
				newEnemyPos = cell;
				minDistance = distance;
			}
		}

		this.totalPanel.getGameArea().moveGameObject(enemy.getPos(), newEnemyPos);
	}

	/**
	 * {@inheritDoc}
	 */
	public void attack(SimpleEnemy enemy, Player player) {
		player.damage(enemy.getWeapon().getDamage());
		if(player.isDead()){
            // TODO lost game/main menu & player stats update
        }
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isPlayerInAttackArea(SimpleEnemy enemy, Player player, Pair<Integer,Integer> roomSize) {
		List<Pair<Integer,Integer>> attackableArea = enemy.getWeapon().getAttackArea(enemy.getPos(), roomSize);
		return (attackableArea.contains(player.getPos()));
	}
	
}
