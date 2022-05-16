package controller.enemyAI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import view.game.central.GameArea;

/**
 * 
 * Implementation of enemies behaviors.
 *
 */
public class EnemyAIImpl implements EnemyAI {

	/**
	 * {@inheritDoc}
	 */
	public void move(SimpleEnemy enemy, Player player, Pair<Integer,Integer> roomSize, GameArea gameArea) {
		List<Pair<Integer,Integer>> enemyReachableArea = enemy.getMovementSystem().reachableCells(enemy.getPos(), roomSize);
		List<Float> distances = new ArrayList<Float>();
		int newX=enemyReachableArea.get(0).getX(), newY=enemyReachableArea.get(0).getY();
		
		for (Pair<Integer,Integer> cell : enemyReachableArea) {			
			distances.add((float) (Math.abs(cell.getX()-player.getPos().getX())/Math.abs(cell.getX()-player.getPos().getY())));
		}
		
		Collections.sort(distances);
        distances.get(0);
		
		gameArea.moveGameObject(enemy.getPos(),new Pair<>(newX,newY));
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
