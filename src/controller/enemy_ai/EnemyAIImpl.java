package controller.enemy_ai;

import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import utilities.RoomConstant;
import view.game.TotalPanel;

/**
 * 
 * Implementation of enemies behaviors.
 *
 */
public class EnemyAIImpl implements EnemyAI {

    final private TotalPanel totalPanel;

    public EnemyAIImpl(final TotalPanel totalPanel) {
        this.totalPanel = totalPanel;
    }

    @Override
    public Pair<Integer, Integer> move(final SimpleEnemy enemy) {
        final List<Pair<Integer, Integer>> enemyReachableArea = enemy.getMovementSystem().reachableCells(enemy.getPos(),
                this.totalPanel.getGameArea().getRoom().getSize());
        final Player player = this.totalPanel.getGameArea().getRoom().getPlayer();
        Pair<Integer, Integer> newEnemyPos = enemy.getPos();
        int minDistance = Integer.MAX_VALUE;
        int distance;
        for (final Pair<Integer, Integer> cell : enemyReachableArea) {
            distance = Math.abs(cell.getX() - player.getPos().getX()) + Math.abs(cell.getY() - player.getPos().getY());
            if (distance < minDistance
                    && !(RoomConstant.cellsOccupated(this.totalPanel.getGameArea().getRoom().getEnemyList(),
                            this.totalPanel.getGameArea().getRoom().getArtefactList(), player, cell))) {
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