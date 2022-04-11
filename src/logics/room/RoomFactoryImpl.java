package logics.room;

import utilis.Constant;

/**
 * 
 * Factory to create new rooms.
 *
 */
public class RoomFactoryImpl implements RoomFactory {

	private static final int x = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(64);
	private static final int y = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(72);

	/**
	 * {@inheritDoc}
	 */
	public Room createRoom() {
		// TODO Auto-generated method stub
		return null;
	}

}
