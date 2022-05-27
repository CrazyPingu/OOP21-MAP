package controller.enemy_ai;

import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import utilities.Pair;

/**
 * 
 * Methods to define enemies behaviors during their turn.
 *
 */
public interface EnemyAI {

    /**
     * Enemy automated movement.
     * 
     * @param enemy: enemy of which is needed to change position
     * @return the new calculated position for the enemy
     */
    Pair<Integer, Integer> move(SimpleEnemy enemy);

    /**
     * Checks if player is reachable by the enemy attack.
     * 
     * @param enemy:    entity of which is needed to know the attackable area
     * @param player:   entity to be found whether or not is in the attackable area
     * @param roomSize: size of the current room
     */
    boolean isPlayerInAttackArea(SimpleEnemy enemy, Player player, Pair<Integer, Integer> roomSize);

}
