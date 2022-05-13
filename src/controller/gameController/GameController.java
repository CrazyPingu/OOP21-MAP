package controller.gameController;

import controller.ActionMenuController;
import controller.GameAreaController;

/**
 * 
 * Manage Game Loop methods
 * 
 */
public abstract class GameController {

    ActionMenuController actionMenuController;
    GameAreaController gameAreaController;

    public GameController() {

        this.actionMenuController = new ActionMenuController(null, null, 0, null);
        this.gameAreaController = new GameAreaController(actionMenuController, null, null, null);

    }

    /**
     * setup the first Game.
     */
    public void startGame() {

    }

    /**
     * create a new Game.
     */
    public void newGame() {

    }

    /**
     * create a new Room.
     */
    public void newRoom() {

    }

    /**
     * 
     * @param actionMenuController
     */

    public abstract void playerTurn(ActionMenuController actionMenuController);

    /**
     * start a new Enemy Turn.
     */
    public abstract void enemyTurn(ActionMenuController actionMenuController);

    /**
     * close the Game.
     */
    public void quitGame() {
        System.exit(0);
    }

}
