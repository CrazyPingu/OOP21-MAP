package controller.enemy_ai;

import java.util.List;

import controller.GameLoop;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Implementation of enemies behaviors.
 *
 */
public class EnemyAIImpl implements EnemyAI {

    private final GameLoop loop;

    public EnemyAIImpl(final GameLoop loop) {
        this.loop = loop;
    }

    @Override
    public Pair<Integer, Integer> move(final SimpleEnemy enemy) {
        final List<Pair<Integer, Integer>> enemyReachableArea = enemy.getMovementSystem().reachableCells(enemy.getPos(),
                this.loop.getRoom().getSize());
        final Player player = this.loop.getRoom().getPlayer();
        Pair<Integer, Integer> newEnemyPos = enemy.getPos();
        int minDistance = Integer.MAX_VALUE;
        int distance;
        for (final Pair<Integer, Integer> cell : enemyReachableArea) {
            distance = Math.abs(cell.getX() - player.getPos().getX()) + Math.abs(cell.getY() - player.getPos().getY());
            if (distance < minDistance
                    && !(RoomConstant.cellsOccupated(this.loop.getRoom().getEnemyList(),
                            this.loop.getRoom().getArtefactList(), player, cell))) {
                newEnemyPos = cell;
                minDistance = distance;
            }
        }
        return newEnemyPos;
    }

    @Override
    public boolean isPlayerInAttackArea(final SimpleEnemy enemy, final Player player, final Pair<Integer, Integer> roomSize) {
        final List<Pair<Integer, Integer>> attackableArea = enemy.getWeapon().getAttackArea(enemy.getPos(), roomSize);
        return attackableArea.contains(player.getPos());
    }

}
