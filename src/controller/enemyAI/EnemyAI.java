package controller.enemyAI;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import view.game.central.GameArea;

/**
 * 
 * Methods to define enemies behaviors during their turn.
 *
 */
public interface EnemyAI {
	
	/**
	 * enemy automated movement
	 */
	public void move(SimpleEnemy enemy, Player player, Pair<Integer,Integer> roomSize, GameArea gameArea);
	
	/**
	 * enemy automated attack
	 */
    public void attack(SimpleEnemy enemy, Player player);
    
    /**
     * checks if player is reachable by the enemy attack
     */
    public boolean isPlayerInAttackArea(SimpleEnemy enemy, Player player, Pair<Integer,Integer> roomSize);

}
