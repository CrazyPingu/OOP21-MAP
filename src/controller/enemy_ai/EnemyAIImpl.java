package controller.enemy_ai;

import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.room.Room;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Implementation of enemies behaviors.
 *
 */
public class EnemyAIImpl implements EnemyAI {

	private Room room;

	public EnemyAIImpl(final Room room) {
		this.room = room;
	}
	
	public void updateAIRoom(final Room room) {
	        this.room = room;
	    }


	@Override
	public Pair<Integer, Integer> move(final SimpleEnemy enemy) {
		final Player player = this.room.getPlayer();
		return enemy.getMovementSystem().reachableCells(enemy.getPos(), this.room.getSize()).stream()
				.sorted((p1, p2) -> Integer.compare(calculateDistanceFromPlayer(p1, player.getPos()),
						calculateDistanceFromPlayer(p2, player.getPos())))
				.filter(i -> !RoomConstant.cellsOccupated(this.room.getEnemyList(),
						this.room.getArtefactList(), player, i))
				.findFirst().get();
	}

	@Override
	public boolean isPlayerInAttackArea(final SimpleEnemy enemy, final Player player,
			final Pair<Integer, Integer> roomSize) {
		return enemy.getWeapon().getAttackArea(enemy.getPos(), roomSize).stream()
				.anyMatch(i -> i.equals(player.getPos()));
	}

	/**
	 * @param cell from which is calculated the distance
	 * @param playerPos player's current position
	 * @return the distance between player's current position and given cell
	 */
	private int calculateDistanceFromPlayer(final Pair<Integer, Integer> cell, final Pair<Integer, Integer> playerPos) {
		return Math.abs(cell.getX() - playerPos.getX()) + Math.abs(cell.getY() - playerPos.getY());
	}

}
