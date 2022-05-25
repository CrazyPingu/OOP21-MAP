package logics.room.type;

import logics.game_object.entity.Player;
import logics.room.RoomImpl;
import utilities.Pair;

/**
 * 
 * Class that define a room with a random size
 *
 */
public class MediumRoom extends RoomImpl {

  public MediumRoom(final Pair<Integer, Integer> size, final Player player) {
    super(size, player, new Pair<Integer, Integer>(0, size.getY() / 2));
  }
}
