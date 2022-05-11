package logics.room.type;

import logics.game_object.entity.Player;
import logics.room.works.RoomImpl;
import utilis.Pair;

/**
 * 
 * Class that define a room with a random size
 *
 */
public class RandomRoom extends RoomImpl {

	/**
	 * {@inheritDoc}
	 */
	public RandomRoom(Pair<Integer, Integer> size, Player player) {
		super(size, player, new Pair<Integer, Integer>(0, size.getY() / 2));

	}

}
