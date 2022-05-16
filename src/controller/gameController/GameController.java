package controller.gameController;

import controller.ActionMenuController;
import controller.GameAreaController;
import controller.RandomRoomGenerator;
import logics.game_object.entity.Player;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.Room;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.texture.EntityTexture;
import utilities.Pair;
import view.game.TotalPanel;

/**
 * 
 * Manage Game Loop methods
 * 
 */
public abstract class GameController {

    private ActionMenuController actionMenuController;
    private GameAreaController gameAreaController;
    private TotalPanel totalPanel;
    private Player player;

    public GameController() {

        this.actionMenuController = new ActionMenuController(totalPanel);
        this.gameAreaController = new GameAreaController(actionMenuController, null, null, null);

    }

    /**
     * setup the first Game.
     */
    public void startGame() {
        WeaponFactoryImpl wf = new WeaponFactoryImpl();
        MovementFactoryImpl mf = new MovementFactoryImpl();
        player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), new Pair<>(3, 3), wf.createAxe(), mf.stepMovement(),
                "Marcello", EntityTexture.PLAYER);
        Room randomRoom = new RandomRoomGenerator().generateRoom(player);

        TotalPanel panel = new TotalPanel(randomRoom, player);
        // this.totalPanel = panel;
    }

    /**
     * create a new Game.
     */
    public void newGame() {
        startGame();
    }

    public TotalPanel getTotalPanel() {
        return this.totalPanel;
        //per ora basta così, se ho altri dubbi ti scrivo ma per ora sono a posto, ciao ciao
    }

    /**
     * 
     * @param actionMenuController
     */

    public abstract void playerTurn(ActionMenuController actionMenuController);

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
