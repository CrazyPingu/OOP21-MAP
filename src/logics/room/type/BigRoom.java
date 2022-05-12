package logics.room.type;

import logics.game_object.entity.Player;
import logics.room.works.RoomImpl;
import utilities.Pair;

/**
 * 
 * Class that define the room with the max size
 *
 */
public class BigRoom extends RoomImpl {
	/**
	 * {@inheritDoc}
	 */
	public BigRoom(Pair<Integer, Integer> size, Player player) {
		super(size, player, new Pair<Integer, Integer>(2, size.getY() / 2));
	}

}
