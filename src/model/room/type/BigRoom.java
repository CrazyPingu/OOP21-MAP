package model.room.type;

import model.game_object.entity.Player;
import model.room.RoomImpl;
import utilities.Pair;

/**
 * 
 * Class that define the room with the max size
 *
 */
public class BigRoom extends RoomImpl {

	public BigRoom(final Pair<Integer, Integer> size,final Player player) {
		super(size, player, new Pair<Integer, Integer>(2, size.getY() / 2));
	}

}
