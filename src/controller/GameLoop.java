package controller;

import controller.game_controller.BasicGameController;
import model.game_object.entity.Player;
import model.game_statistics.GameStatisticsImpl;
import model.life.impl.ExtendibleMaxLifeSystem;
import model.room.Room;
import model.strategy.movement.MovementFactoryImpl;
import model.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;
import view.end_game_menu.Defeat;
import view.end_game_menu.Victory;
import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loading_screen.LoadingScreenImpl;
import view.main_menu.MainMenu;
import view.pause.PauseMenu;

public class GameLoop {
  private final BasicFrame frame;

  private final LoadingScreenImpl loadingScreen;

  private final ActionMenuController actionMenuController;
  private final GameAreaController gameAreaController;
  private final PageController pageController;
  private BasicGameController gameController;

  public GameLoop() {
    frame = new BasicFrame();
    this.actionMenuController = new ActionMenuController(this);
    this.gameAreaController = new GameAreaController(this);
    this.pageController = new PageController(frame, this);

    this.loadingScreen = new LoadingScreenImpl(this.pageController);
    final MainMenu mainMenu = new MainMenu(this.pageController);
    frame.addToCardLayout(mainMenu, "MainMenu");
    final PauseMenu pauseMenu = new PauseMenu(this.pageController);
    frame.addToCardLayout(pauseMenu, "PauseMenu");
    final Victory victory = new Victory("Victory", this.pageController);
    frame.addToCardLayout(victory, "Victory");
    final Defeat defeat = new Defeat("Defeat", this.pageController);
    frame.addToCardLayout(defeat, "Defeat");
    frame.addToCardLayout(loadingScreen, "LoadingScreen");
    this.pageController.showMainMenu();
  }

  public void newGame() {
    final GameStatisticsImpl gameStats = new GameStatisticsImpl();
    this.loadingScreen.startProgressBar();
    final WeaponFactoryImpl wf = new WeaponFactoryImpl();
    final MovementFactoryImpl mf = new MovementFactoryImpl();
    final Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), wf.createStick(), mf.stepMovement(), "Marcello",
        EntityTexture.PLAYER);
    final Room randomRoom = gameAreaController.generateNewRoom(player);
    final TotalPanel totalPanel = new TotalPanel(randomRoom, actionMenuController, gameAreaController, pageController, gameStats);
    frame.addToCardLayout(totalPanel, "Game");
    gameController = new BasicGameController(gameAreaController, totalPanel, pageController, gameStats);
  }

  public void skipTurn() {
    this.gameController.skipTurn();
  }

  public void setFlag(final ActionFlag flag) {
    this.gameController.setFlag(flag);
  }

  /**
   * When this method is called the game loop start;
   */
  public void startGame() {
    this.newGame();
  }

  public void makeAction(final Pair<Integer, Integer> pos) {
    this.gameController.makeAction(pos);

  }
}
