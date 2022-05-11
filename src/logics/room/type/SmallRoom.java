package logics.room.type;

import logics.game_object.entity.Player;
import logics.room.works.RoomImpl;
import utilis.Pair;

/**
 * 
 * Class that define the room with the smallest size
 *
 */
public class SmallRoom extends RoomImpl {

	/**
	 * {@inheritDoc}
	 */
	public SmallRoom(Pair<Integer, Integer> size, Player player) {
		super(size, player, new Pair<Integer, Integer>(1, size.getY() / 2));
	}

}
