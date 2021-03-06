package model.room;

/**
 * 
 * Interface that declares methods to generate room.
 *
 */
public interface RoomFactory {

	/**
	 * @return a new room that will be the maximum size.
	 */
	Room createBigRoom();
	
	/**
	 * @return a new room that will be the minimum size.
	 */
	Room createSmallRoom();
	
	/**
	 * @return a new room that will have a random size.
	 */
	Room createMediumRoom();
	
}
