package logics.room;

import java.util.Map;

import logics.entity.Entity;
import utilis.Pair;

/**
 * 
 * Interface that declares methods to generate room.
 *
 */
public interface RoomFactory {

	/**
	 * @return a new room that will be .
	 */
	public Room createBigRoom();
}
