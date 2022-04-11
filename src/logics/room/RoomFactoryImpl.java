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

	private final int maxX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(64);
	private final int maxY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(72);
	private final Pair<Integer, Integer> max = new Pair<Integer, Integer>(maxX, maxY);

	/**
	 * {@inheritDoc}
	 */
	public Room createBigRoom() {
		Pair<Integer, Integer> playerPos = new Pair<>(1, max.getY() / 2);
		return new RoomImpl(max, playerPos, new GenerateRandomEnemyMap(max));
	}

}
