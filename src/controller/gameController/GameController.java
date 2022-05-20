package controller.gameController;

import controller.ActionFlag;
import controller.ActionMenuController;
import controller.GameAreaController;
import controller.PageController;
import logics.game_object.artefact.Artefact;
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

    public GameController(ActionMenuController actionMenuController, GameAreaController gameAreaController,
            BasicFrame frame, PageController pageController) {
        this.actionMenuController = actionMenuController;
        this.gameAreaController = gameAreaController;
        this.pageController = pageController;
        this.frame = frame;
    }

    /**
     * setup the first Game.
     */
    public void startGame() {
        WeaponFactoryImpl wf = new WeaponFactoryImpl();
        MovementFactoryImpl mf = new MovementFactoryImpl();
        player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), wf.createStick(), mf.stepMovement(), "Marcello",
                EntityTexture.PLAYER);
        Room randomRoom = gameAreaController.generateNewRoom();
        this.totalPanel = new TotalPanel(randomRoom, actionMenuController, gameAreaController, pageController);
        frame.addToCardLayout(totalPanel, "Game");
    }

    /**
     * start a new Enemy Turn.
     */
    public abstract void enemyTurn();

    /**
     * 
     * @return if the door of the room is available
     */
    public abstract boolean isDoorAvailable();

    /**
     * 
     * @return if the player won the game
     */
    public abstract boolean isWon();

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
    private void attack(Pair<Integer, Integer> pos) {
        SimpleEnemy enemy = RoomConstant.searchEnemy(pos, this.totalPanel.getGameArea().getRoom().getEnemyList());
        if (enemy != null) {
            enemy.damage(this.player.getWeapon().getDamage());
            this.getTotalPanel().getScrollableLog().getLogMessage().update(enemy.getName() + " è stato colpito.");
        } else {
            this.getTotalPanel().getScrollableLog().getLogMessage()
                    .update(this.player.getName() + " ha mancato il colpo.");
        }
        this.endPlayerTurn();
    }

    /**
     * Move in a chosen cell by the user
     * 
     * @param newpos : the new position of the player
     */
    private void move(Pair<Integer, Integer> newpos) {
        if (RoomConstant.searchEnemy(newpos, this.totalPanel.getGameArea().getRoom().getEnemyList()) == null) {
            Artefact artefact = RoomConstant.searchArtefact(newpos,
                    this.totalPanel.getGameArea().getRoom().getArtefactList());
            if (artefact != null) {
                artefact.execute(player);
                this.totalPanel.getGameArea().removeGameObject(newpos);
                this.getTotalPanel().getScrollableLog().getLogMessage().update("Raccolto " + artefact.getName() + ".");
                this.getTotalPanel().getScrollableStats().getStatsValues().update(player);
                ;
            }
            this.totalPanel.getGameArea().moveGameObject(player.getPos(), newpos);
            if (this.totalPanel.getGameArea().getRoom().playerOnDoor()) {
                //this.roomCounter++; TODO
                this.totalPanel.getGameArea().changeRoom(this.gameAreaController.generateNewRoom());
            }
        }
        this.endPlayerTurn();
    }

    /**
     * 
     * @return the player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * 
     * @return if the player is dead
     */
    public boolean isDead() {
        return this.player.isDead();
    }

    /**
     * 
     * @return the total panel
     */
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
     * @return the number of action of the player
     */
    public int getCurrentActionNumber() {
        return currentActionNumber;
    }

    /**
     * 
     * @param currentActionNumber the number of action available by the player
     * 
     *                            Set the number of action
     */
    public void setCurrentActionNumber(int currentActionNumber) {
        this.currentActionNumber = currentActionNumber;
    }

    /**
     * end the turn of the player
     */
    private void endPlayerTurn() {
        this.totalPanel.getActionMenu().enableButton();
        this.totalPanel.getGameArea().removeHighlight();
        this.decreaseAction();
    }

    /**
     * 
     * @param pos the pos of the player
     */
    public void makeAction(Pair<Integer, Integer> pos) {
        if (this.flag.equals(ActionFlag.ATTACK)) {
            this.attack(pos);
        } else if (this.flag.equals(ActionFlag.MOVE)) {
            this.move(pos);
        }

    }

}
