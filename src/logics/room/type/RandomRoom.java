package logics.room.type;

import logics.room.works.RandomEnemyMap;
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
	public RandomRoom(Pair<Integer, Integer> size) {
		super(size, new Pair<Integer, Integer>(0, size.getY() / 2), new RandomEnemyMap(size));

	}

}
