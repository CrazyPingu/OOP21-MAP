package logics.room.type;

import logics.room.works.RandomEnemyMap;
import logics.room.works.RoomImpl;
import utilis.Pair;

public class SmallRoom extends RoomImpl {

	public SmallRoom(Pair<Integer, Integer> size) {
		super(size, new Pair<Integer, Integer>(1, size.getY() / 2), new RandomEnemyMap(size));
	}

}
