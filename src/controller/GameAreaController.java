package controller;

import logics.room.works.Room;
import utilities.Pair;

public class GameAreaController {

    private GameLoop gameLoop;
    private RandomRoomGenerator randomRoomGenerator;

    public GameAreaController(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
        this.randomRoomGenerator = new RandomRoomGenerator();
    }

    /**
     * create a new Room.
     */
    public Room generateNewRoom() {
        return randomRoomGenerator.generateRoom(gameLoop.getPlayer());
    }

    /**
     * 
     * @param pos : the position of the pressed cell
     */
    public void makeAction(Pair<Integer, Integer> pos) {
        this.gameLoop.makeAction(pos);
    }

}
