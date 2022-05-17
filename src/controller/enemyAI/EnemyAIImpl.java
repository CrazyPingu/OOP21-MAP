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

	public EnemyAIImpl(TotalPanel totalPanel, Player player) {
		this.totalPanel = totalPanel;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Pair<Integer, Integer> move(SimpleEnemy enemy) {
		final List<Pair<Integer, Integer>> enemyReachableArea = enemy.getMovementSystem().reachableCells(enemy.getPos(),
				this.totalPanel.getGameArea().getRoom().getSize());
		final Player player = this.totalPanel.getGameArea().getRoom().getPlayer();
		Pair<Integer, Integer> newEnemyPos = enemy.getPos();
		int minDistance = Integer.MAX_VALUE;
		int distance = -1;

		for (Pair<Integer, Integer> cell : enemyReachableArea) {
			distance = Math.abs(cell.getX() - player.getPos().getX()) + Math.abs(cell.getY() - player.getPos().getY());
			if (distance < minDistance) {
				newEnemyPos = cell;
				minDistance = distance;
			}
		}

		return newEnemyPos;
	}

	/**
	 * {@inheritDoc}
	 */
	public void attack(SimpleEnemy enemy, Player player) {
		player.damage(enemy.getWeapon().getDamage());
		if (player.isDead()) {
			// TODO lost game/main menu (pageController)
		} else {
			this.totalPanel.getScrollableStats().getStatsValues().update(player);
			this.totalPanel.getScrollableLog().getLogMessage().update("" + player.getName() + " ha subito " + enemy.getWeapon().getDamage()
					+ " da " + enemy.getName() + "!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isPlayerInAttackArea(SimpleEnemy enemy, Player player, Pair<Integer, Integer> roomSize) {
		final List<Pair<Integer, Integer>> attackableArea = enemy.getWeapon().getAttackArea(enemy.getPos(), roomSize);
		return (attackableArea.contains(player.getPos()));
	}
	
}
