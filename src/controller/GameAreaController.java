package controller;

import controller.gameController.GameController;
import logics.room.works.Room;
import utilities.Pair;

public class GameAreaController {

    private GameController gameController;
    private RandomRoomGenerator randomRoomGenerator;

    public GameAreaController(GameController gameController) {
        this.gameController = gameController;
        this.randomRoomGenerator = new RandomRoomGenerator();
    }

    /**
     * create a new Room.
     */
    public Room generateNewRoom() {
        return randomRoomGenerator.generateRoom(gameController.getPlayer());
    }

    /**
     * 
     * @param pos : the position of the pressed cell
     */
    public void makeAction(Pair<Integer, Integer> pos) {
        if (this.gameController.getFlag().equals(ActionFlag.ATTACK)) {
            this.gameController.attack(pos);
        } else if (this.gameController.getFlag().equals(ActionFlag.MOVE)) {
            this.gameController.move(pos);
        }
    }

}
