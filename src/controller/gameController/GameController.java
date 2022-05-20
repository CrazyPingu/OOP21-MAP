package controller.gameController;

import controller.ActionFlag;
import controller.GameAreaController;
import controller.PageController;
import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import utilities.RoomConstant;
import view.game.TotalPanel;
import logics.game_statistics.GameStatisticsImpl;

/**
 * 
 * Manage Game Loop methods
 * 
 */
public abstract class GameController {

    private GameAreaController gameAreaController;
    private TotalPanel totalPanel;
    private PageController pageController;
    private ActionFlag flag;
    private int currentActionNumber;
    private GameStatisticsImpl gameStats;

    public GameController(GameAreaController gameAreaController, TotalPanel totalPanel, PageController pageController,
            GameStatisticsImpl gameStats) {
        this.totalPanel = totalPanel;
        this.pageController = pageController;
        this.gameStats = gameStats;
        this.gameAreaController = gameAreaController;
        this.currentActionNumber = this.getPlayer().getActionNumber();
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

    public GameStatisticsImpl getGameStats() {
        return this.gameStats;
    }

    public PageController getPageController() {
        return this.pageController;
    }

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
        this.totalPanel.getGameArea().removeHighlight();
        this.currentActionNumber = 0;
        this.enemyTurn();
    }

    /**
     * Attack in a chosen cell by the user
     */
    private void attack(Pair<Integer, Integer> pos) {
        SimpleEnemy enemy = RoomConstant.searchEnemy(pos, this.totalPanel.getGameArea().getRoom().getEnemyList());
        if (enemy != null) {
            enemy.damage(this.getPlayer().getWeapon().getDamage());
            if (enemy.isDead()) {
                this.totalPanel.getGameArea().removeGameObject(pos);
            }
            this.getTotalPanel().getScrollableLog().getLogMessage().update(enemy.getName() + " got hit");
        } else {
            this.getTotalPanel().getScrollableLog().getLogMessage()
                    .update(this.getPlayer().getName() + " miss the attack");
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
                artefact.execute(this.getPlayer());
                this.totalPanel.getGameArea().removeGameObject(newpos);
                this.getTotalPanel().getScrollableLog().getLogMessage().update("Picked up " + artefact.getName() + ".");
                this.getTotalPanel().getScrollableStats().getStatsValues().update(this.getPlayer(), this.gameStats);
            }
            this.totalPanel.getGameArea().moveGameObject(this.getPlayer().getPos(), newpos);
            if (this.totalPanel.getGameArea().getRoom().playerOnDoor()) {
                this.gameStats.increaseCompletedRooms();
                this.totalPanel.getGameArea().changeRoom(this.gameAreaController.generateNewRoom(this.getPlayer()));
            }
        }
        this.endPlayerTurn();
    }

    /**
     * 
     * @return the player
     */
    public Player getPlayer() {
        return this.totalPanel.getGameArea().getRoom().getPlayer();
    }

    /**
     * 
     * @return if the player is dead
     */
    public boolean isDead() {
        return this.getPlayer().isDead();
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
        this.totalPanel.getGameArea().removeHighlight();
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
     * reset the number of action available by the player
     *
     */
    public void resetActionNumber() {
        this.currentActionNumber = this.getPlayer().getActionNumber();
    }

    /**
     * end the turn of the player
     */
    private void endPlayerTurn() {
        this.totalPanel.getGameArea().removeHighlight();
        this.decreaseAction();
        if (this.getCurrentActionNumber() == 0) {
            enemyTurn();
        }
        this.isWon();
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
