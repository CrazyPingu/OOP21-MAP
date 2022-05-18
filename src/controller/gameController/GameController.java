package controller.gameController;

import controller.ActionFlag;
import controller.ActionMenuController;
import controller.GameAreaController;
import controller.RandomRoomGenerator;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.Room;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.texture.EntityTexture;
import utilities.Pair;
import utilities.RoomConstant;
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
    private ActionFlag flag;
    private int currentAction;

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
        // per ora basta così, se ho altri dubbi ti scrivo ma per ora sono a posto, ciao
        // ciao
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
     * Specify the type of action to apply to GameArea's chosen cell.
     * 
     * @param actionFlag : set the ActionFlag
     */
    public void setFlag(ActionFlag flag) {
        this.flag = flag;
        this.totalPanel.getGameArea().highlightCells(this.flag);
    }

    /**
     * 
     * @return the ActionFlag
     */
    public ActionFlag getFlag() {
        return this.flag;
    }

    /**
     * Decrease the number of available action
     */
    public void decreaseAction() {
        this.currentAction--;
    }

    /**
     * Skip the turn
     */
    public void skipTurn() {
        this.currentAction = 0;
    }
    
    
    /**
     * Attack in a chosen cell by the user
     */
    public void attack(Pair<Integer, Integer> pos) {
        if (RoomConstant.searchEnemy(pos, this.gameArea.getRoom().getEnemyList()) != null) {
            SimpleEnemy enemy = RoomConstant.searchEnemy(pos, this.gameArea.getRoom().getEnemyList());
            enemy.damage(this.gameArea.getRoom().getPlayer().getWeapon().getDamage());
        }
        this.decreaseAction();
    }

    /**
     * Move in a chosen cell by the user
     * 
     * @param newpos : the new position of the player
     */
    public void move(Pair<Integer, Integer> newpos) {
        if (RoomConstant.searchEnemy(newpos, this.gameArea.getRoom().getEnemyList()) == null) {
            this.gameArea.moveGameObject(player.getPos(), newpos);
            if (RoomConstant.searchArtefact(newpos,
                    this.gameArea.getRoom().getArtefactList()) != null) {
                RoomConstant.searchArtefact(newpos, this.gameArea.getRoom().getArtefactList())
                        .execute(player);
            }
        }
        this.decreaseAction();
    }
    
    public Player getPlayer() {
        return this.player;
    }
    

}
