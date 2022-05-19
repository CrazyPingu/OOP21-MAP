package controller;

import controller.gameController.BasicGameController;
import controller.gameController.GameController;
import logics.game_object.entity.Player;
import utilities.Pair;
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
    private MainMenu mainMenu;
    private TotalPanel totalPanel;
    private PauseMenu pauseMenu;
    private Victory victory;
    private Defeat defeat;
    private BasicGameController gameController;
    private ActionMenuController actionMenuController;
    private GameAreaController gameAreaController;
    private PageController pageController;
    private boolean newGamePressed;

    public GameLoop() {
        this.init();
        this.pageController.showMainMenu();
        while (true) {
            if (this.newGamePressed) {
                this.newGamePressed = false;
                this.loadingScreen = new LoadingScreenImpl(this.pageController);
                frame.addToCardLayout(loadingScreen, "LoadingScreen");
                this.loadingScreen.startProgressBar();
                this.gameController = new BasicGameController(this.actionMenuController, this.gameAreaController,
                        this.frame, this.pageController);
                this.match();
            }
        }
    }

    private void init() {
        frame = new BasicFrame();
        this.actionMenuController = new ActionMenuController(this);
        this.gameAreaController = new GameAreaController(this);
        this.pageController = new PageController(frame, this);
        this.newGamePressed = false;

        this.mainMenu = new MainMenu(pageController);
        frame.addToCardLayout(mainMenu, "MainMenu");
        this.pauseMenu = new PauseMenu(this.pageController);
        frame.addToCardLayout(pauseMenu, "PauseMenu");
        this.victory = new Victory("Victory", this.pageController);
        frame.addToCardLayout(victory, "Victory");
        this.defeat = new Defeat("Defeat", this.pageController);
        frame.addToCardLayout(defeat, "Defeat");
    }

    public ActionFlag getFlag() {
        return this.gameController.getFlag();
    }

    public void attack(Pair<Integer, Integer> pos) {
        this.gameController.attack(pos);
    }

    public void move(Pair<Integer, Integer> pos) {
        this.gameController.move(pos);
    }

    public Player getPlayer() {
        return this.gameController.getPlayer();
    }

    public void skipTurn() {
        this.gameController.skipTurn();
    }

    public void setFlag(ActionFlag flag) {
        this.gameController.setFlag(flag);
    }

    private void match() {
        this.gameController.startGame();
        while (!this.gameController.getPlayer().isDead() || this.gameController.getRoomCounter() > 3) {
            this.gameController.playerTurn();
            this.gameController.enemyTurn();
        }
        if (this.gameController.getPlayer().isDead()) {
            this.pageController.showDefeat();
        } else if (this.gameController.getRoomCounter() >= 3) {
            this.pageController.showVictory();
        }
    }

    /**
     * When this method is called the game loop start;
     */
    public void startGame() {
        this.newGamePressed = true;
    }
}
