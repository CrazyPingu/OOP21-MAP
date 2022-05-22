package controller;

import logics.game_object.entity.Player;
import logics.room.Room;
import utilities.Pair;

public class GameAreaController {

    private final GameLoop gameLoop;
    private final RandomRoomGenerator randomRoomGenerator;

    public GameAreaController(final GameLoop gameLoop) {
        this.gameLoop = gameLoop;
        this.randomRoomGenerator = new RandomRoomGenerator();
    }

    /**
     * create a new Room.
     */
    public Room generateNewRoom(final Player player) {
        return randomRoomGenerator.generateRoom(player);
    }

    /**
     * 
     * @param pos : the position of the pressed cell
     */
    public void makeAction(final Pair<Integer, Integer> pos) {
        this.gameLoop.makeAction(pos);
    }

}
