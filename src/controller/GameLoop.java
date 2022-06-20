package controller;

import controller.game_controller.BasicGameController;
import model.game_object.entity.Player;
import model.game_statistics.GameStatisticsImpl;
import model.life_system.impl.ExtendibleMaxLifeSystem;
import model.movement.MovementFactoryImpl;
import model.room.Room;
import model.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;
import view.BasicFrame;
import view.end_game_menu.Defeat;
import view.end_game_menu.Victory;
import view.game.TotalPanel;
import view.loading_screen.LoadingScreenImpl;
import view.main_menu.MainMenu;
import view.pause.PauseMenu;
/*
 * 
 * class that contains main methods for manage the player turn
 * 
 */
public class GameLoop {
  private final BasicFrame frame;

  private final LoadingScreenImpl loadingScreen;
  private TotalPanel totalPanel;

  private final ActionMenuController actionMenuController;
  private final GameAreaController gameAreaController;
  private final PageController pageController;
  private BasicGameController gameController;
  private Room room;
  private Player player;

  public GameLoop() {
    frame = new BasicFrame();
    this.actionMenuController = new ActionMenuController(this);
    this.gameAreaController = new GameAreaController(this);
    this.pageController = new PageController(frame, this);

    this.loadingScreen = new LoadingScreenImpl(this.pageController);
    final MainMenu mainMenu = new MainMenu(this.pageController);
    frame.addToCardLayout(mainMenu, CardName.MAIN_MENU);
    final PauseMenu pauseMenu = new PauseMenu(this.pageController);
    frame.addToCardLayout(pauseMenu, CardName.PAUSE_MENU);
    final Victory victory = new Victory("Victory", this.pageController);
    frame.addToCardLayout(victory, CardName.VICTORY);
    final Defeat defeat = new Defeat("Defeat", this.pageController);
    frame.addToCardLayout(defeat, CardName.DEFEAT);
    frame.addToCardLayout(loadingScreen, CardName.LOADING_SCREEN);
    this.pageController.showMainMenu();
  }

  /**
   * method that create a new game
   */
  public void newGame() {
    final GameStatisticsImpl gameStats = new GameStatisticsImpl();
    this.loadingScreen.startProgressBar();
    final WeaponFactoryImpl wf = new WeaponFactoryImpl();
    final MovementFactoryImpl mf = new MovementFactoryImpl();
    this.player = new Player(new ExtendibleMaxLifeSystem(10, 10, 20), wf.createStick(), mf.stepMovement(), "Marcello",
        EntityTexture.PLAYER);
    this.room = gameAreaController.generateNewRoom(player);
    this.totalPanel = new TotalPanel(this, actionMenuController, gameAreaController, pageController, gameStats);
    frame.addToCardLayout(totalPanel, CardName.TOTAL_PANEL);
    gameController = new BasicGameController(gameAreaController, pageController, this, gameStats);
  }

  /**
   * method that make the player skip the current turn
   */
  public void skipTurn() {
    this.gameController.skipTurn();
  }

  /**
   * 
   * @param flag the flag we set
   */
  public void setFlag(final ActionFlag flag) {
    this.gameController.setFlag(flag);
  }

  /**
   * When this method is called the game loop start
   */
  public void startGame() {
    this.newGame();
  }

  /**
   * 
   * @param pos the pos of the player in the game field
   */
  public void makeAction(final Pair<Integer, Integer> pos) {
    this.gameController.makeAction(pos);
  }

  /**
   * 
   * @return the Room
   */
  public Room getRoom() {
    return this.room;
  }

  /**
   * 
   * @return the Player
   */
  public Player getPlayer() {
    return this.player;
  }

  /**
   * 
   * @return theGame Area Controller
   */
  public GameAreaController getGameAreaController() {
    return gameAreaController;
  }

  /**
   * 
   * @param text text to update in scrollable log
   */
  public void updateLog(final String text) {
    this.gameAreaController.updateLog(this.totalPanel.getScrollableLog(), text);
  }

  /**
   * 
   * @param statistics   the stats to update in scrollable stats
   * @param actionNumber the remaining number of action available by the player
   */
  public void updateStats(final GameStatisticsImpl statistics, final int actionNumber) {
    this.gameAreaController.updateStats(this.totalPanel.getScrollableStats(), player, statistics, actionNumber);
  }

  /**
  * method that remove the highlited cells during player turn
  */
  public void removeHighlight() {
    this.gameAreaController.removeHighlight(this.totalPanel.getGameArea());
  }

  /**
   * 
   * @param flag the flag setted at that moment
   */
  public void highlightCells(final ActionFlag flag) {
    this.gameAreaController.highlightCells(flag, this.totalPanel.getGameArea());
  }

  /**
   * 
   * @param oldPos the actual position of the object
   * @param newPos the new position of the object
   */
  public void moveGameObject(final Pair<Integer, Integer> oldPos, final Pair<Integer, Integer> newPos) {
    this.gameAreaController.moveGameObject(oldPos, newPos);
  }

  /**
   * method that shows a new room
   */
  public void changeRoom() {
    this.gameAreaController.changeRoom(this.player, this.totalPanel.getGameArea());
  }

  /**
   * 
   * @param room the room
   */
  public void setRoom(final Room room) {
    this.room = room;
  }
}
