package controller;

import controller.gameController.BasicGameController;
import controller.gameController.GameController;
import logics.game_object.entity.Player;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.Room;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;
import view.endGameMenu.EndGameMenu;
import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loadingScreen.LoadingScreenImpl;
import view.mainMenu.MainMenu;
import view.pause.PauseMenu;
import view.endGameMenu.Victory;
import view.endGameMenu.Defeat;

public class GameLoop {
    private BasicFrame frame;

    private LoadingScreenImpl loadingScreen;
    private TotalPanel totalPanel;
    private Player player;

    private ActionMenuController actionMenuController;
    private GameAreaController gameAreaController;
    private PageController pageController;

    private BasicGameController gameController;

    public GameLoop() {
        frame = new BasicFrame();
        this.actionMenuController = new ActionMenuController(this);
        this.gameAreaController = new GameAreaController(this);
        this.pageController = new PageController(frame, this);

        this.loadingScreen = new LoadingScreenImpl(this.pageController);
        MainMenu mainMenu = new MainMenu(this.pageController);
        frame.addToCardLayout(mainMenu, "MainMenu");
        PauseMenu pauseMenu = new PauseMenu(this.pageController);
        frame.addToCardLayout(pauseMenu, "PauseMenu");
        Victory victory = new Victory("Victory", this.pageController);
        frame.addToCardLayout(victory, "Victory");
        Defeat defeat = new Defeat("Defeat", this.pageController);
        frame.addToCardLayout(defeat, "Defeat");
        frame.addToCardLayout(loadingScreen, "LoadingScreen");
        this.pageController.showMainMenu();
    }

    public void newGame() {
        this.loadingScreen.startProgressBar();
        WeaponFactoryImpl wf = new WeaponFactoryImpl();
        MovementFactoryImpl mf = new MovementFactoryImpl();
        this.player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), wf.createStick(), mf.stepMovement(),
                "Marcello", EntityTexture.PLAYER);
        Room randomRoom = gameAreaController.generateNewRoom(player);
        this.totalPanel = new TotalPanel(randomRoom, actionMenuController, gameAreaController, pageController);
        frame.addToCardLayout(totalPanel, "Game");
        gameController = new BasicGameController(gameAreaController, totalPanel, pageController);
    }

    public void skipTurn() {
        this.gameController.skipTurn();
    }

    public void setFlag(ActionFlag flag) {
        this.gameController.setFlag(flag);
    }

    /**
     * When this method is called the game loop start;
     */
    public void startGame() {
        this.newGame();
    }

    public void makeAction(Pair<Integer, Integer> pos) {
        this.gameController.makeAction(pos);

    }
}
