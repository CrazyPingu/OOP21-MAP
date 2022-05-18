package controller;

import controller.gameController.GameController;
import logics.game_object.entity.Player;
import utilities.Pair;
import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loadingScreen.LoadingScreenImpl;
import view.pause.PauseMenu;

public class GameLoop {
    private BasicFrame frame;
    private LoadingScreenImpl loadingScreen;
    private MainMenu mainMenu;
    private TotalPanel totalPanel;
    private PauseMenu pauseMenu;
    private WinGame winGame;
    private LoseGame loseGame;
    private BasicGameController gameController;
    private ActionMenuController actionMenuController;
    private GameAreaController gameAreaController;
    private PageController pageController;

    public GameLoop() {
        this.init();
        while(true) {
            this.pageController.showMainMenu();
            if(/* mainMenuController flag ha premuto new game */) {
                this.loadingScreen = new LoadingScreenImpl(this.pageController);
                frame.addToCardLayout(loadingScreenImpl, "LoadingScreen");
                this.pageController.showLoadingScreen();
                this.loadingScreen.startProgressBar();
                this.match();
            }
        }
        // main menu - loading screen - creazione total panel(new room da
        // gameAreaController)

        // while True
        // conterrà while(getcurrentactionnumber>0) turno player
        
        
        /*
         *         
         *         
        frame.addToCardLayout(totalPanel, "Game");
         *         
         */

    }

    private void init() {
        this.gameController = new BasicGameController();
        this.actionMenuController = new ActionMenuController(this);
        this.gameAreaController = new GameAreaController(this);
        this.pageController = new PageController(frame);
        // TODO add main menu controller

        this.mainMenu = new MainMenu(/* add controller */);
        frame.addToCardLayout(mainMenu, "MainMenu");
        this.pauseMenu = new PauseMenu(this.pageController);
        frame.addToCardLayout(pauseMenu, "PauseMenu");
        this.winGame = new winGame(this.pageController);
        frame.addToCardLayout(winGame, "Win");
        this.loseGame = new LoseGame(this.pageController);
        frame.addToCardLayout(loseGame, "Defeat");
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
        while(/* player dead  || numero stanze   */) {
            this.gameController.playerTurn();
            this.gameController.enemyTurn();
        }
    }

}
