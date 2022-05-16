package controller.gameController;

import controller.ActionMenuController;
import controller.GameAreaController;
import controller.RandomRoomGenerator;
import logics.game_object.entity.Player;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.Room;
import logics.strategy.concrete_strategies.AroundArea;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilis.texture.EntityTexture;
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

    public GameController() {

        this.actionMenuController = new ActionMenuController(totalPanel);
        this.gameAreaController = new GameAreaController(actionMenuController, null, null, null);

    }
s
    /**
     * setup the first Game.
     */
    public void startGame() {
        WeaponFactoryImpl wf = new WeaponFactoryImpl();
        MovementFactoryImpl mf = new MovementFactoryImpl();
        Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), new Pair<>(3, 3), wf.createAxe(),
                mf.stepMovement(), "Marcello", EntityTexture.PLAYER);
        Room randomRoom = new RandomRoomGenerator().generateRoom(player);

        TotalPanel panel = new TotalPanel(randomRoom, player);
        //this.totalPanel = panel;
    }

    /**
     * create a new Game.
     */
    public void newGame() {
        startGame();
    }

    /**
     * create a new Room.
     */
    public void newRoom() {
        Room randomRoom = new RandomRoomGenerator().generateRoom(player);

    }

    
    
    public TotalPanel getTotalPanel(TotalPanel panel) {
        return this.totalPanel;
        
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
