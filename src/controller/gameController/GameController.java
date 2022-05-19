package controller.gameController;

import controller.ActionFlag;
import controller.ActionMenuController;
import controller.GameAreaController;
import controller.PageController;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.Room;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.texture.EntityTexture;
import utilities.Pair;
import utilities.RoomConstant;
import view.frame.BasicFrame;
import view.game.TotalPanel;

/**
 * 
 * Manage Game Loop methods
 * 
 */
public abstract class GameController {

    private ActionMenuController actionMenuController;
    private GameAreaController gameAreaController;
    private PageController pageController;
    private TotalPanel totalPanel;
    private Player player;
    private ActionFlag flag;
    private int currentActionNumber;
    private BasicFrame frame;
    private int roomCounter;

    public GameController(ActionMenuController actionMenuController, GameAreaController gameAreaController,
            BasicFrame frame, PageController pageController) {
        this.actionMenuController = actionMenuController;
        this.gameAreaController = gameAreaController;
        this.pageController = pageController;
        this.frame = frame;
        this.roomCounter = 0;
    }

    /**
     * setup the first Game.
     */
    public void startGame() {
        WeaponFactoryImpl wf = new WeaponFactoryImpl();
        MovementFactoryImpl mf = new MovementFactoryImpl();
        player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), new Pair<>(3, 3), wf.createStick(),
                mf.stepMovement(), "Marcello", EntityTexture.PLAYER);
        Room randomRoom = gameAreaController.generateNewRoom();
        this.totalPanel = new TotalPanel(randomRoom, actionMenuController, gameAreaController, pageController);
        frame.addToCardLayout(totalPanel, "Game");
    }

    /**
     * 
     * @param actionMenuController
     */

    public abstract void playerTurn();

    /**
     * start a new Enemy Turn.
     */
    public abstract void enemyTurn();

    /**
     * Decrease the number of available action
     */
    public void decreaseAction() {
        this.currentActionNumber--;
    }

    /**
     * Skip the turn
     */
    public void skipTurn() {
        this.currentActionNumber = 0;
    }

    /**
     * Attack in a chosen cell by the user
     */
    public void attack(Pair<Integer, Integer> pos) {
        if (RoomConstant.searchEnemy(pos, this.totalPanel.getGameArea().getRoom().getEnemyList()) != null) {
            SimpleEnemy enemy = RoomConstant.searchEnemy(pos, this.totalPanel.getGameArea().getRoom().getEnemyList());
            enemy.damage(this.totalPanel.getGameArea().getRoom().getPlayer().getWeapon().getDamage());
        }
        this.totalPanel.getActionMenu().enableButton();
        this.decreaseAction();
    }

    /**
     * Move in a chosen cell by the user
     * 
     * @param newpos : the new position of the player
     */
    public void move(Pair<Integer, Integer> newpos) {
        if (RoomConstant.searchEnemy(newpos, this.totalPanel.getGameArea().getRoom().getEnemyList()) == null) {
            if (RoomConstant.searchArtefact(newpos,
                    this.totalPanel.getGameArea().getRoom().getArtefactList()) != null) {
                RoomConstant.searchArtefact(newpos, this.totalPanel.getGameArea().getRoom().getArtefactList())
                        .execute(player);
                this.totalPanel.getGameArea().removeGameObject(newpos);                
            }
            this.totalPanel.getGameArea().moveGameObject(player.getPos(), newpos);
            if (this.totalPanel.getGameArea().getRoom().playerOnDoor()) {
                this.roomCounter++;
                this.totalPanel.getGameArea().changeRoom(this.gameAreaController.generateNewRoom());
            }
        }
        this.totalPanel.getActionMenu().enableButton();
        this.decreaseAction();
    }

    public Player getPlayer() {
        return this.player;
    }

    public TotalPanel getTotalPanel() {
        return this.totalPanel;
    }

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

    public int getRoomCounter() {
        return this.roomCounter;
    }

    public int getCurrentActionNumber() {
        return currentActionNumber;
    }

    public void setCurrentActionNumber(int currentActionNumber) {
        this.currentActionNumber = currentActionNumber;
    }

}
