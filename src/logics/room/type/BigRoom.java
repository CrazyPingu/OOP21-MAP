package logics.room.type;

import logics.room.works.RandomEnemyMap;
import logics.room.works.RoomImpl;
import utilis.Pair;
/**
 * 
 * Class that define the room with the max size
 *
 */
public class BigRoom extends RoomImpl {
	/**
	 * {@inheritDoc}
	 */
	public BigRoom(Pair<Integer, Integer> size) {
		super(size, new Pair<Integer, Integer>(2, size.getY() / 2), new RandomEnemyMap(size));
	}

}
