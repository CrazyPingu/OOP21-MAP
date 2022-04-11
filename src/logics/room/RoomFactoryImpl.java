package logics.room;

import java.util.Map;
import logics.entity.Entity;
import utilis.Constant;
import utilis.Pair;

/**
 * 
 * Factory to create new rooms.
 *
 */
public class RoomFactoryImpl implements RoomFactory {

	private static final int MaxX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(64);
	private static final int MaxY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(72);

	/**
	 * {@inheritDoc}
	 */
	public Room createBigRoom(Map<Pair<Integer, Integer>, Entity> enemy) {
		return new RoomImpl(new Pair<Integer, Integer>(MaxX,MaxY), null, enemy);
	}
	
}
