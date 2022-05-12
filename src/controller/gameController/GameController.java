package controller.gameController;

/**
 * 
 * Manage Game Loop methods
 * 
 */
public abstract class GameController {

    ActionMenuController actionMenuController;
    GameAreaController gameAreaController;

    public GameController() {

        this.actionMenuController = new ActionMenuController();
        this.gameAreaController = new GameAreaController();

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
     * start a new Player Turn.
     */
    public abstract void playerTurn();

    /**
     * start a new Enemy Turn.
     */
    public abstract void enemyTurn();

    /**
     * close the Game.
     */
    public void quitGame() {
        System.exit(0);
    }

}
