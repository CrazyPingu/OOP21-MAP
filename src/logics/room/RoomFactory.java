package logics.room;

/**
 * 
 * Interface that declares methods to generate room.
 *
 */
public interface RoomFactory {

	/**
	 * @return a new room that will be the maximum size.
	 */
	public Room createBigRoom();
	
	/**
	 * @return a new room that will be the minimum size.
	 */
	public Room createSmallRoom();
	
	
}
